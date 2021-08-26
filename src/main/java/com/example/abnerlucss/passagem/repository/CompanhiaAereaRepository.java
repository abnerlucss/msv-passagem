package com.example.abnerlucss.passagem.repository;

import com.example.abnerlucss.passagem.model.CompanhiaAerea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanhiaAereaRepository extends JpaRepository<CompanhiaAerea, Integer> {
    CompanhiaAerea findByIdentificadorComp(String identificadorCompanhia);
}
