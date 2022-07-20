package com.kazantsev.rectime.controllers;

import com.kazantsev.rectime.models.Clients;
import com.kazantsev.rectime.repo.ClientsRepository;
import com.kazantsev.rectime.repo.RoleRepository;
import com.kazantsev.rectime.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientsController {

    @Autowired
    private ClientsRepository  clientsRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/addclient")
    public String setclient(Model model) {
        System.out.println("add client");
        return "addclient";
    }



    @PostMapping("/addclient")
    public String addclient(Model model, @RequestParam String username, @RequestParam String surename) {

        System.out.println("before");

       userService.saveUser(new Clients( surename,username ));
        System.out.println("past");



        return "view";
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        Iterable<Clients> clientslist = clientsRepository.findAll();
        model.addAttribute("clientslist", clientslist);
        return "clients";
    }
}
