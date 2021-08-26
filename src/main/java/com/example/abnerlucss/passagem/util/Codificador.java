package com.example.abnerlucss.passagem.util;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@Component
public class Codificador {

    public String gerarCodigoLocalizador(String cpf, String destino, String codigoCompanhia, String classe, LocalDateTime DataHoraEmbarque, LocalDateTime DataHoraDesembarque) {

        String codigo = cpf + destino + codigoCompanhia + classe + DataHoraEmbarque.toString() + DataHoraDesembarque.toString();

        return Base64.getEncoder().encodeToString(codigo.getBytes(StandardCharsets.UTF_8));
    }
}
