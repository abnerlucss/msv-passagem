package com.example.abnerlucss.passagem.services;

import com.example.abnerlucss.passagem.DTOs.CompanhiaAereaDTO;
import com.example.abnerlucss.passagem.mappers.CompanhiaAereaMapper;
import com.example.abnerlucss.passagem.repositories.CompanhiaAereaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanhiaAereaService {

    @Autowired
    private CompanhiaAereaRepository companhiaAereaRepository;

    @Autowired
    private CompanhiaAereaMapper companhiaAereaMapper;

    public List<CompanhiaAereaDTO> listarCompanhiasAereas() {
        return companhiaAereaMapper.converterListaEntidadeParaDTO(companhiaAereaRepository.findAll());
    }

}
