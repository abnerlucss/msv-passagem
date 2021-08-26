package com.example.abnerlucss.passagem.controllers;

import com.example.abnerlucss.passagem.DTOs.*;
import com.example.abnerlucss.passagem.exceptions.CreateException;
import com.example.abnerlucss.passagem.exceptions.NotFoundException;
import com.example.abnerlucss.passagem.services.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/passagem")
@SuppressWarnings("unused")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<PassagemDTO> cadastrarPassagem(@RequestBody VooDTO body) throws NotFoundException, CreateException {
        return passagemService.cadastrarPassagem(body);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PassagemCompradaDTO comprarPassagem(@RequestBody DadosCompraDTO body) throws NotFoundException, CreateException {
        return passagemService.comprarPassagem(body);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensDisponiveis(){
        return passagemService.listarPassagensDisponiveis();
    }

}
