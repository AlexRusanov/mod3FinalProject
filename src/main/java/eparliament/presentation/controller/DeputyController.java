package eparliament.presentation.controller;

import eparliament.service.DeputyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

/**
 * Created by alexandrrusanov on 26/8/17.
 */
@Controller
@RequestMapping("deputies")
public class DeputyController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");

    private DeputyService deputyService;

    @Autowired
    public DeputyController(DeputyService deputyService) {
        this.deputyService = deputyService;
    }

    @GetMapping
    public String showDeputies(Model model){
        model.addAttribute("deputies", deputyService.getAll());
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "deputy/deputy-list";
    }
}
