package com.kazantsev.rectime.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class MainController {

    @GetMapping("/rectime")
    public String hello(Model model) {
        model.addAttribute("tittle", "rectime this");

        return "view";
    }



}
