package com.example.abnerlucss.passagem.controller;

import com.example.abnerlucss.passagem.DTO.DadosCompraDTO;
import com.example.abnerlucss.passagem.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.passagem.DTO.PassagemDTO;
import com.example.abnerlucss.passagem.DTO.VooDTO;
import com.example.abnerlucss.passagem.exception.CreateException;
import com.example.abnerlucss.passagem.exception.ListException;
import com.example.abnerlucss.passagem.exception.NotFoundException;
import com.example.abnerlucss.passagem.service.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/passagem")
@CrossOrigin(origins = "*")
@SuppressWarnings("unused")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<PassagemDTO> cadastrarPassagem(@RequestBody VooDTO body) throws CreateException {
        return passagemService.cadastrarPassagem(body);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PassagemCompradaDTO comprarPassagem(@RequestBody DadosCompraDTO body) throws NotFoundException, CreateException {
        return passagemService.comprarPassagem(body);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensDisponiveis() {
        return passagemService.listarPassagensDisponiveis();
    }

    @GetMapping("/idVoo/{idVoo}")
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensPorIdVoo(@PathVariable Integer idVoo) throws ListException {
        return passagemService.listarPassagensPorIdVoo(idVoo);
    }

    @GetMapping("/disponiveis/idVoo/{idVoo}")
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensDisponiveisPorIdVoo(@PathVariable Integer idVoo) throws ListException {
        return passagemService.listarPassagensDisponiveisPorIdVoo(idVoo);
    }

    @GetMapping("/idVoo/{idVoo}/{classe}")
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensPorIdVooClasse(@PathVariable Integer idVoo, @PathVariable String classe) throws ListException {
        return passagemService.listarPassagensPorIdVooClasse(idVoo, classe);
    }

    @GetMapping("/indisponiveis/idVoo/{idVoo}")
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensIndisponiveisPorIdVoo(@PathVariable Integer idVoo) throws ListException {
        return passagemService.listarPassagensIndisponiveisPorIdVoo(idVoo);
    }


    @GetMapping("/indisponiveis")
    @ResponseStatus(HttpStatus.OK)
    public List<PassagemDTO> listarPassagensIndisponiveis() throws ListException {
        return passagemService.listarPassagensIndisponiveis();
    }
}
