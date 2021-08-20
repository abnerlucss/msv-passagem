package com.example.abnerlucss.msvticket.mappers;

import com.example.abnerlucss.msvticket.DTOs.CompanhiaAereaDTO;
import com.example.abnerlucss.msvticket.models.CompanhiaAerea;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanhiaAereaMapper {

    public List<CompanhiaAereaDTO> converterListaEntidadeParaDTO(List<CompanhiaAerea> companhiaAereas) {
        return companhiaAereas.stream().map(companhiaAerea -> new CompanhiaAereaDTO(
                companhiaAerea.getIdCompanhiaAerea(),
                companhiaAerea.getNome(),
                companhiaAerea.getCodigo(),
                companhiaAerea.getIdentificadorComp()
        )).collect(Collectors.toList());
    }
}
