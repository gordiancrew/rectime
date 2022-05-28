package com.kazantsev.rectime.controllers;

import com.kazantsev.rectime.models.Specialists;
import com.kazantsev.rectime.repo.SpecialistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SpecialistsController {

    @Autowired
    private SpecialistsRepository specialistsRepository;

    @GetMapping("/specialists")
    public String Specialists(Model model) {
        Iterable<Specialists> specialistslist = specialistsRepository.findAll();
        model.addAttribute("specialistlist", specialistslist);
        return "specialists";
    }

    @GetMapping("/addspecialist")
    public String setspecialist(Model model) {
        return "addspecialist";
    }

    @PostMapping("/addspecialist")
    public String addspecialist(Model model, @RequestParam String name, @RequestParam String surename) {

        Specialists sp = new Specialists(name, surename);
        specialistsRepository.save(new Specialists(name, surename));
        return "specialists";
    }

    @GetMapping("/specprofile")
    public String specprofile(Model model, @RequestParam String specid) {

        int specidint = Integer.parseInt(specid);
        Specialists spec = specialistsRepository.findById(specidint).get();
        model.addAttribute("spec", spec);
        return "specprofile";
    }

    @PostMapping("/deletespecialist")
    public String deletebook(Model model, @RequestParam String speciddel) {
        int id = Integer.parseInt(speciddel);
        Specialists spec = specialistsRepository.findById(id).get();
        specialistsRepository.delete(spec);
        model.addAttribute("info","Specialist is delete");
        return "infopage";
    }
}
