package com.example.abnerlucss.passagem.controller;

import com.example.abnerlucss.passagem.DTO.PassageiroDTO;
import com.example.abnerlucss.passagem.exception.*;
import com.example.abnerlucss.passagem.service.PassageiroService;
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
    public List<PassageiroDTO> listarPassageiros() throws ListException {
        return passageiroService.listarPassageiros();
    }

    
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroDTO buscarPassageiroPorId(@PathVariable Integer id) throws NotFoundException, ConvertException {
        return passageiroService.buscarPassageiroPorId(id);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroDTO buscarPassageiroPorCpf(@PathVariable String cpf) throws NotFoundException, ConvertException {
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
