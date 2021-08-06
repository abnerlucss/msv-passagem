package com.example.abnerlucss.msvticket.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CryptographerCodigo {
    public String gerarCodigoLocalizador(String codigoCompanhia, String classe, Date data, Date horaEmbarque){
        String codigo = codigoCompanhia+classe+data.toString()+horaEmbarque.toString();
        return codigo;
    }
}
