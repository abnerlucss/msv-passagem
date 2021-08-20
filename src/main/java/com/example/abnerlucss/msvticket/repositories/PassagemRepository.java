package com.example.abnerlucss.msvticket.repositories;

import com.example.abnerlucss.msvticket.models.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {
    @Query(value = "select * from passagem where id_passageiro isnull", nativeQuery = true)
    List<Passagem> findAllPassagensDisponiveis();

}
