package com.example.abnerlucss.passagem.repositories;

import com.example.abnerlucss.passagem.models.CompanhiaAerea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanhiaAereaRepository extends JpaRepository<CompanhiaAerea, Integer> {
    CompanhiaAerea findByIdentificadorComp(String identificadorCompanhia);
}
