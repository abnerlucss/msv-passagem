package com.example.abnerlucss.msvticket.mappers;

import com.example.abnerlucss.msvticket.DTOs.ClasseDTO;
import com.example.abnerlucss.msvticket.models.Classe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClasseMapper {

    public List<ClasseDTO> converterListaEntidadeParaDTO (List<Classe> classes){
        return classes.stream().map(classe -> new ClasseDTO(
                classe.getIdClasse(),
                classe.getNome(),
                classe.getDescricao())
        ).collect(Collectors.toList());
    }

}
