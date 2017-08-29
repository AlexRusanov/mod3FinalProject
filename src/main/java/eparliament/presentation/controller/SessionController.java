package eparliament.presentation.controller;

import eparliament.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
@Controller
@RequestMapping("sessions")
public class SessionController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");

    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public String showSessions(Model model){
        model.addAttribute("sessions", sessionService.getAll());
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "session/session-list";
    }
}
