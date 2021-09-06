package com.example.abnerlucss.passagem.repository;

import com.example.abnerlucss.passagem.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {
    Optional<Passageiro> findByCpf(String cpf);

    @Query(value = "select * from passageiro p where p.cpf = :cpf and p.senha = :senha", nativeQuery = true)
    Optional<Passageiro> loginPassageiro(@Param("cpf") String cpf, @Param("senha") String senha);

}
