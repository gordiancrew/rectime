package com.kazantsev.rectime.controllers;

import com.kazantsev.rectime.uploader.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {
    @Value("${web.upload-path}")
    private String path;

    @RequestMapping("/uploadfile")
    public String upload(Model model, @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (FileUtils.upload(file, path, fileName)) {
            model.addAttribute("tittle", "upload is successful");

        } else {
            model.addAttribute("tittle", "upload is error");
        }


        return "view";
    }
}