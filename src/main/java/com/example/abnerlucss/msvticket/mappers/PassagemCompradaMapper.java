package com.example.abnerlucss.msvticket.mappers;

import com.example.abnerlucss.msvticket.DTOs.PassagemCompradaDTO;
import com.example.abnerlucss.msvticket.models.Passageiro;
import com.example.abnerlucss.msvticket.models.Passagem;
import com.example.abnerlucss.msvticket.util.Codificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassagemCompradaMapper {

    @Autowired
    private Codificador codificador;

    public PassagemCompradaDTO converteEntidadeParaDTO(Passageiro passageiro, Passagem passagem){

        String codigoLocalizador = codificador.gerarCodigoLocalizador(
                passageiro.getCpf(),
                passageiro.getCpf(),
                passagem.getCompanhiaAerea().getCodigo(),
                passagem.getClasse().getNome(),
                passagem.getDataHoraEmbarque()
        );

        return new PassagemCompradaDTO(
                passageiro.getNome(),
                passageiro.getCpf(),
                codigoLocalizador
        );
    }

}
