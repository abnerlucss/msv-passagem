package com.example.abnerlucss.passagem.controllers;

import com.example.abnerlucss.passagem.DTOs.CompanhiaAereaDTO;
import com.example.abnerlucss.passagem.services.CompanhiaAereaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/companhia")
public class CompanhiaAereaController {

    @Autowired
    private CompanhiaAereaService companhiaAereaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanhiaAereaDTO> listarCompanhiasAereas(){
        return this.companhiaAereaService.listarCompanhiasAereas();
    }

}
