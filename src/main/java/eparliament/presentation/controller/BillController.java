package eparliament.presentation.controller;

import eparliament.service.BillService;
import eparliament.service.SessionService;
import eparliament.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
@Controller
@RequestMapping("bills")
public class BillController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");
    private final int PAGE_SIZE = 5;

    private BillService billService;
    private SessionService sessionService;
    private VotingService votingService;

    @Autowired
    public BillController(BillService billService, SessionService sessionService, VotingService votingService) {
        this.billService = billService;
        this.sessionService = sessionService;
        this.votingService = votingService;
    }

    @GetMapping("{sessionId}/sessionbills")
    public String showSessionBills(Model model, @PathVariable("sessionId") Integer sessionId, @RequestParam(value = "page", defaultValue = "1") int page){
        int offset = (page - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;

        model.addAttribute("sessionbills", billService.getBySession(sessionId, offset, limit));
        model.addAttribute("billCount", billService.getCount());
        model.addAttribute("pageSize", PAGE_SIZE);
        model.addAttribute(sessionService.getById(sessionId));
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "bill/sessionbill-list";
    }

    @GetMapping("{sessionId}/sessionbills/{billId}")
    public String showSessionBill(Model model, @PathVariable("billId") Integer billId, @PathVariable("sessionId") Integer sessionId){
        model.addAttribute("bill", billService.getById(billId));
        model.addAttribute("billVoting", votingService.getByBill(billId));
        model.addAttribute("billSession", sessionService.getById(sessionId));
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "bill/bill";
    }


}
