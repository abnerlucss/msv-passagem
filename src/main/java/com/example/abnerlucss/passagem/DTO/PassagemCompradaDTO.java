package com.example.abnerlucss.passagem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassagemCompradaDTO {

    private String nomePassageiro;
    private String cpfPassageiro;
    private String codigoLocalizador;
}
