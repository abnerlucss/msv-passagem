package com.example.abnerlucss.msvticket.repositories;

import com.example.abnerlucss.msvticket.models.CompanhiaAerea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanhiaAereaRepository extends JpaRepository<CompanhiaAerea, Integer> {
    CompanhiaAerea findByIdentificadorComp(String identificadorCompanhia);
}
