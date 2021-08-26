package com.example.abnerlucss.passagem.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    
}
