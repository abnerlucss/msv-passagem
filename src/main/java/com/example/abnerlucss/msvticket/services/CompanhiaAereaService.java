package com.example.abnerlucss.msvticket.services;

import com.example.abnerlucss.msvticket.DTOs.CompanhiaAereaDTO;
import com.example.abnerlucss.msvticket.mappers.CompanhiaAereaMapper;
import com.example.abnerlucss.msvticket.repositories.CompanhiaAereaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanhiaAereaService {

    @Autowired
    private CompanhiaAereaRepository companhiaAereaRepository;

    @Autowired
    private CompanhiaAereaMapper companhiaAereaMapper;

    public List<CompanhiaAereaDTO> listarCompanhiasAereas (){
        return companhiaAereaMapper.converterListaEntidadeParaDTO(companhiaAereaRepository.findAll());
    }

}
