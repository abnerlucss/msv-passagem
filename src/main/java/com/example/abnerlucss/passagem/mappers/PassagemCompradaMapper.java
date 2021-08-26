package com.example.abnerlucss.passagem.mappers;

import com.example.abnerlucss.passagem.DTOs.PassagemCompradaDTO;
import com.example.abnerlucss.passagem.models.Passageiro;
import com.example.abnerlucss.passagem.models.Passagem;
import com.example.abnerlucss.passagem.util.Codificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassagemCompradaMapper {

    @Autowired
    private Codificador codificador;

    public PassagemCompradaDTO converteEntidadeParaDTO(Passageiro passageiro, Passagem passagem){

        String codigoLocalizador = codificador.gerarCodigoLocalizador(
                passageiro.getCpf(),
                passagem.getDestino(),
                passagem.getCompanhiaAerea().getCodigo(),
                passagem.getClasse().getNome(),
                passagem.getDataHoraEmbarque(),
                passagem.getDataHoraDesembarque()
        );

        return new PassagemCompradaDTO(
                passageiro.getNome(),
                passageiro.getCpf(),
                codigoLocalizador
        );
    }

}
