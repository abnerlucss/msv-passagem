package com.example.abnerlucss.passagem.mapper;

import com.example.abnerlucss.passagem.DTO.ClasseDTO;
import com.example.abnerlucss.passagem.model.Classe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClasseMapper {

    public List<ClasseDTO> converterListaEntidadeParaDTO(List<Classe> classes) {

        return classes.stream().map(classe -> ClasseDTO.builder()
                .id(classe.getIdClasse())
                .nome(classe.getNome())
                .descricao(classe.getDescricao())
                .build()
        ).collect(Collectors.toList());

    }

}
