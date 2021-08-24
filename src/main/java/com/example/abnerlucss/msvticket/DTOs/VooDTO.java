package com.example.abnerlucss.msvticket.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VooDTO {

    private Integer idVoo;

    private String aeroporto;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraEmbarque;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraDesembarque;

    private String destino;

    private String identificadorCompanhia;

    private Integer qtdEconomica;

    private Integer qtdExecutiva;

    private Integer qtdPrimeiraClasse;

    private String status;

    private Integer idPortao;

    public VooDTO(String aeroporto, LocalDateTime dataHoraEmbarque, LocalDateTime dataHoraDesembarque, String destino, String identificadorCompanhia, Integer qtdEconomica, Integer qtdExecutiva, Integer qtdPrimeiraClasse, String status, Integer idPortao) {
        this.aeroporto = aeroporto;
        this.dataHoraEmbarque = dataHoraEmbarque;
        this.dataHoraDesembarque = dataHoraDesembarque;
        this.destino = destino;
        this.identificadorCompanhia = identificadorCompanhia;
        this.qtdEconomica = qtdEconomica;
        this.qtdExecutiva = qtdExecutiva;
        this.qtdPrimeiraClasse = qtdPrimeiraClasse;
        this.status = status;
        this.idPortao = idPortao;
    }
}
