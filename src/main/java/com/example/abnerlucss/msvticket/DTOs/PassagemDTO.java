package com.example.abnerlucss.msvticket.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PassagemDTO {

    private Integer idPassagem;

    private String aeroporto;

    private String destino;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEmbarque;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaEmbarque;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaDesembarque;

    private int numeroAssento;

    private String nomeClasse;

    private String nomeCompanhia;


}
