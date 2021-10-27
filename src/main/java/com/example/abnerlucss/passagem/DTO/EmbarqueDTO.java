package com.example.abnerlucss.passagem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmbarqueDTO {
    private Integer idEmbarque;

    private LocalDateTime dataHoraEmbarque;

    private String classe;

    private String codigoLocalizador;

    private String identificadorComp;

    private Integer numeroAssento;

    private String destino;

    private String partida;

    private String aeroporto;

    private Integer idVoo;
}
