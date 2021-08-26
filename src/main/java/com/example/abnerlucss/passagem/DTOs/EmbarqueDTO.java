package com.example.abnerlucss.passagem.DTOs;

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
    private LocalDateTime dataHoraEmbarque;
    private String classe;
    private String codigoLocalizador;
    private String identificadorComp;
    private Integer numeroAssento;
    private String destino;

}
