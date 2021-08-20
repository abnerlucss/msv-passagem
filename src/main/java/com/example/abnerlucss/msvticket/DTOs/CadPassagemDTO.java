package com.example.abnerlucss.msvticket.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CadPassagemDTO {

    private String aeroporto;

    private String destino;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEmbarque;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaEmbarque;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaDesembarque;

    private int numeroAssento;

    private Integer idClasse;

    private Integer idCompanhia;
}
