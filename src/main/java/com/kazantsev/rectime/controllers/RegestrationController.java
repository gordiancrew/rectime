package com.kazantsev.rectime.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RegestrationController {

    @GetMapping("/registration")
    public String reg(Model model){
        return "login";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String login, Model model){
        System.out.println("go reg");
        if(login.equals("www"))

            return "redirect:/";
            return "login";


    }

}
