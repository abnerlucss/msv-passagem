package com.example.abnerlucss.passagem.repositories;

import com.example.abnerlucss.passagem.models.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {
    Optional<Passageiro> findByCpf(String cpf);

}
