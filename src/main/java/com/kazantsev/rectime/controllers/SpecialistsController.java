package com.kazantsev.rectime.controllers;

import com.kazantsev.rectime.models.Specialists;
import com.kazantsev.rectime.repo.SpecialistsRepository;
import com.kazantsev.rectime.uploader.FileNameUtils;
import com.kazantsev.rectime.uploader.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;

@Controller
public class SpecialistsController {
    @Value("${web.upload-path}")
    private String path;

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
    public String addspecialist(Model model, @RequestParam String name, @RequestParam String surename, @RequestParam MultipartFile file) {

        String newFileName = FileNameUtils.getFileName(file.getOriginalFilename());
        //Specialists sp = new Specialists(name, surename);
        specialistsRepository.save(new Specialists(name, surename, newFileName));


        if (FileUtils.upload(file, path, newFileName)) {
            model.addAttribute("tittle", "upload is successful");

        } else {
            model.addAttribute("tittle", "upload is error");
        }

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
        model.addAttribute("info", "Specialist is delete");
        return "infopage";
    }
}
