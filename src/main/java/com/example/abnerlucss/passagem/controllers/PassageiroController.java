package com.example.abnerlucss.passagem.controllers;

import com.example.abnerlucss.passagem.DTOs.PassageiroDTO;
import com.example.abnerlucss.passagem.exceptions.CreateException;
import com.example.abnerlucss.passagem.exceptions.DeleteException;
import com.example.abnerlucss.passagem.exceptions.NotFoundException;
import com.example.abnerlucss.passagem.exceptions.UpdateException;
import com.example.abnerlucss.passagem.services.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@SuppressWarnings("unused")
@RequestMapping("/v1/passageiro")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassageiroDTO cadastrarPassageiro(@RequestBody @Valid PassageiroDTO body) throws CreateException {
        return passageiroService.cadastrarPassageiro(body);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PassageiroDTO> listarPassageiros() {
        return passageiroService.listarPassageiros();
    }

    
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroDTO buscarPassageiroPorId(@PathVariable Integer id) throws NotFoundException {
        return passageiroService.buscarPassageiroPorId(id);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroDTO buscarPassageiroPorCpf(@PathVariable String cpf) throws NotFoundException {
        return passageiroService.buscarPassageiroPorCpf(cpf);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroDTO atualizarPassageiroPorId(@PathVariable Integer id, @RequestBody PassageiroDTO body) throws NotFoundException, UpdateException {
        return passageiroService.atualizarPassageiro(id, body);
    }


    @PutMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroDTO atualizarPassageiroPorCpf(@PathVariable String cpf, @RequestBody PassageiroDTO body) throws NotFoundException, UpdateException {
        return passageiroService.atualizarPassageiro(cpf, body);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> excluirPassageiroPorId(@PathVariable Integer id) throws DeleteException {
        return ResponseEntity.ok(this.passageiroService.excluirPassageiroPorId(id));
    }

    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public String excluirPassageiroPorCpf(@PathVariable String cpf) throws DeleteException, NotFoundException {
        return passageiroService.excluirPassageiroPorCpf(cpf);
    }


}
