package com.example.abnerlucss.passagem.controller;

import com.example.abnerlucss.passagem.DTO.CompanhiaAereaDTO;
import com.example.abnerlucss.passagem.exception.ListException;
import com.example.abnerlucss.passagem.service.CompanhiaAereaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/companhia")
@CrossOrigin(origins = "*")
public class CompanhiaAereaController {

    @Autowired
    private CompanhiaAereaService companhiaAereaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanhiaAereaDTO> listarCompanhiasAereas() throws ListException {
        return this.companhiaAereaService.listarCompanhiasAereas();
    }

}
