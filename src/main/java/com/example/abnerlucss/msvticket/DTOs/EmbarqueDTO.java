package com.example.abnerlucss.msvticket.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmbarqueDTO {
    private Date dataEmbarque;
    private Date horaEmbarque;
    private String classe;
    private String codigoLocalizador;
    private String identificadorComp;
    private Integer numeroAssento;
    private String destino;

    @Override
    public String toString() {
        return "EmbarqueDTO{" +
                "dataEmbarque=" + dataEmbarque +
                ", horaEmbarque=" + horaEmbarque +
                ", classe='" + classe + '\'' +
                ", codigoLocalizador='" + codigoLocalizador + '\'' +
                ", identificadorComp='" + identificadorComp + '\'' +
                ", numeroAssento=" + numeroAssento +
                ", destino='" + destino + '\'' +
                '}';
    }
}
