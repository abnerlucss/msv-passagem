package com.example.abnerlucss.msvticket.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CadPassagemDTO {

    private String aeroporto;

    private String destino;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss" , timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraEmbarque;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss" , timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraDesembarque;

    private int numeroAssento;

    private Integer idClasse;

    private Integer idCompanhia;
}
