package com.example.abnerlucss.passagem.mapper;

import com.example.abnerlucss.passagem.DTO.CompanhiaAereaDTO;
import com.example.abnerlucss.passagem.model.CompanhiaAerea;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanhiaAereaMapper {

    public List<CompanhiaAereaDTO> converterListaEntidadeParaDTO(List<CompanhiaAerea> companhiaAereas) {
        return companhiaAereas.stream().map(companhiaAerea -> CompanhiaAereaDTO.builder()
                .id(companhiaAerea.getIdCompanhiaAerea())
                .nome(companhiaAerea.getNome())
                .codigo(companhiaAerea.getCodigo())
                .identificadorComp(companhiaAerea.getIdentificadorComp())
                .build()
        ).collect(Collectors.toList());
    }
}
