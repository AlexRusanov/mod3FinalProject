package eparliament.presentation.controller;

import eparliament.domain.Bill;
import eparliament.domain.User;
import eparliament.service.BillService;
import eparliament.service.SessionService;
import eparliament.service.UserService;
import eparliament.util.exception.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
@Controller
public class RootController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");

    private UserService userService;
    private BillService billService;
    private SessionService sessionService;

    public RootController(UserService userService, BillService billService, SessionService sessionService) {
        this.userService = userService;
        this.billService = billService;
        this.sessionService = sessionService;
    }

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("newUser") User user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.registerNewUser(user);
        return "redirect:/";
    }

    @GetMapping("/myBills")
    public String showBillsForUser(Model model) {
        model.addAttribute("userBills", billService.getAllByAuthUser());
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "user/userbill-list";
    }

    @GetMapping("/myBills/{billId}")
    public String editBillPage(@PathVariable("billId") Integer billId, Model model) {
        model.addAttribute("bill", billService.getById(billId));
        return "user/bill-edit";
    }

    @PostMapping("/myBills/{billId}")
    public String editBill(@Valid @ModelAttribute Bill bill,
                              BindingResult bindingResult,
                              @PathVariable("billId") Integer billId,
                              RedirectAttributes redirectAttributes) {
        if  (bindingResult.hasErrors()) {
            return "user/bill-edit";
        }
        bill.setId(billId);
        billService.update(bill);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/myBills/" + billId;
    }

    @GetMapping("/myBills/newBill")
    public String newBillPage(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("isNew", true);
        return "user/bill-edit";
    }

    @PostMapping("/myBills/newBill")
    public String editBill(@Valid @ModelAttribute Bill bill,
                              BindingResult bindingResult,
                              Model model, RedirectAttributes redirectAttributes) {
        if  (bindingResult.hasErrors()) {
            model.addAttribute("isNew", true);
            return "user/bill-edit";
        }
        User authUser = userService.getAuthenticatedUser()
                .orElseThrow(() -> new AccessDeniedException("User are not authorized"));
        Bill createdBill = billService.create(bill, authUser);
        redirectAttributes.addFlashAttribute("createIsSuccessful", true);
        return "redirect:/myBills/" + createdBill.getId();
    }

    @PostMapping("/myBills/{billId}/delete")
    public String deleteProduct(@PathVariable("billId") Integer billId) {
        billService.delete(billId);
        return "redirect:/myBills/";
    }
}
