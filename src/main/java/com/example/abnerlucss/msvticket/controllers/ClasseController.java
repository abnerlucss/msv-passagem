package com.example.abnerlucss.msvticket.controllers;

import com.example.abnerlucss.msvticket.DTOs.ClasseDTO;
import com.example.abnerlucss.msvticket.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/classe")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClasseDTO> listarClasses(){
        return classeService.listarClasses();
    }

}
