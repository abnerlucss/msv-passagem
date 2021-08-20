package com.example.abnerlucss.msvticket.util;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Component
public class Codificador {

    public String gerarCodigoLocalizador(String cpf, String destino, String codigoCompanhia, String classe, Date dataEmbarque, Date horaEmbarque){

        String formatDataEmbarque = new SimpleDateFormat("dd-MM-yyyy").format(dataEmbarque);
        String formatHoraEmbarque = new SimpleDateFormat("HH:mm:ss").format(horaEmbarque);

        String codigo = cpf+destino+codigoCompanhia+classe+formatDataEmbarque+formatHoraEmbarque;

        System.out.println(codigo);
        return Base64.getEncoder().encodeToString(codigo.getBytes(StandardCharsets.UTF_8));
    }
}
