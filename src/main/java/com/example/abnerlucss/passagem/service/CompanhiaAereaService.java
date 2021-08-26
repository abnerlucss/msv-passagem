package com.example.abnerlucss.passagem.service;

import com.example.abnerlucss.passagem.DTO.CompanhiaAereaDTO;
import com.example.abnerlucss.passagem.exception.ListException;
import com.example.abnerlucss.passagem.mapper.CompanhiaAereaMapper;
import com.example.abnerlucss.passagem.repository.CompanhiaAereaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanhiaAereaService {

    @Autowired
    private CompanhiaAereaRepository companhiaAereaRepository;

    @Autowired
    private CompanhiaAereaMapper companhiaAereaMapper;

    public List<CompanhiaAereaDTO> listarCompanhiasAereas() throws ListException {
        try {
            return companhiaAereaMapper.converterListaEntidadeParaDTO(companhiaAereaRepository.findAll());
        } catch (Exception e) {
            throw new ListException("Erro ao listar companhias aéreas", e.getCause());
        }
    }

}
