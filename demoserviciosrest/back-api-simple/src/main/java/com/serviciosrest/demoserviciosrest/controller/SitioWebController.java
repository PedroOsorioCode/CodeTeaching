package com.serviciosrest.demoserviciosrest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SitioWebController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "hogar/index";
    }

}