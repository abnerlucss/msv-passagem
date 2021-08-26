package com.example.abnerlucss.passagem.repository;

import com.example.abnerlucss.passagem.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
    Classe findByNome(String nome);
}
