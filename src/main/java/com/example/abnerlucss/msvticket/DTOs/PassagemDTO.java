package com.example.abnerlucss.msvticket.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassagemDTO {

    private Integer idPassagem;

    private String aeroporto;

    private String destino;

    private LocalDateTime dataHoraEmbarque;

    private LocalDateTime dataHoraDesembarque;

    private int numeroAssento;

    private String nomeClasse;

    private String nomeCompanhia;


}
