package eparliament.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
@Controller
public class RootController {

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }
}
