package com.example.abnerlucss.passagem.repositories;

import com.example.abnerlucss.passagem.models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
    Classe findByNome(String nome);
}
