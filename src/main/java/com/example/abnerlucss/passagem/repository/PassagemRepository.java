package com.example.abnerlucss.passagem.repository;

import com.example.abnerlucss.passagem.model.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {
    @Query(value = "select * from passagem where id_passageiro isnull", nativeQuery = true)
    List<Passagem> findAllPassagensDisponiveis();

    @Query(value = "select * from passagem where id_passageiro is not null", nativeQuery = true)
    List<Passagem> findAllPassagensIndisponiveis();

    @Query(value = "select * from passagem p where p.id_passageiro is not null and p.id_voo = :idVoo", nativeQuery = true)
    List<Passagem> findAllPassagensIndisponiveis(@Param("idVoo") Integer idVoo);

    @Query(value = "select * from passagem p where p.id_passageiro isnull and p.id_voo = :idVoo", nativeQuery = true)
    List<Passagem> findAllPassagensDisponiveisPorVoo(@Param("idVoo") Integer idVoo);

    List<Passagem> findAllPassagensDisponiveisByIdVoo(Integer idVoo);
}
