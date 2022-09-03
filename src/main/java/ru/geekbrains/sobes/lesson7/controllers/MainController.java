package ru.geekbrains.sobes.lesson7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class MainController {

    @GetMapping
    public String home() {
        return "index";
    }
}
