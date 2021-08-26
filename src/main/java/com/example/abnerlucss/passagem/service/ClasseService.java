package com.example.abnerlucss.passagem.service;

import com.example.abnerlucss.passagem.DTO.ClasseDTO;
import com.example.abnerlucss.passagem.exception.ListException;
import com.example.abnerlucss.passagem.mapper.ClasseMapper;
import com.example.abnerlucss.passagem.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ClasseMapper classeMapper;

    public List<ClasseDTO> listarClasses() throws ListException {
        try {
            return classeMapper.converterListaEntidadeParaDTO(classeRepository.findAll());
        }
        catch (Exception e){
            throw new ListException("Erro ao listar Classes", e.getCause());
        }
    }
}
