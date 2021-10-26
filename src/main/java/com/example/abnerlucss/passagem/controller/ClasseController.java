package com.example.abnerlucss.passagem.controller;

import com.example.abnerlucss.passagem.DTO.ClasseDTO;
import com.example.abnerlucss.passagem.exception.ListException;
import com.example.abnerlucss.passagem.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/classe")
@CrossOrigin(origins = "*")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClasseDTO> listarClasses() throws ListException {
        return classeService.listarClasses();
    }

}
