package com.example.abnerlucss.passagem.services;

import com.example.abnerlucss.passagem.DTOs.ClasseDTO;
import com.example.abnerlucss.passagem.mappers.ClasseMapper;
import com.example.abnerlucss.passagem.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ClasseMapper classeMapper;

    public List<ClasseDTO> listarClasses() {
        return classeMapper.converterListaEntidadeParaDTO(classeRepository.findAll());
    }
}
