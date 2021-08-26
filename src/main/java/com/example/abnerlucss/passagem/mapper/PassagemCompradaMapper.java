package com.example.abnerlucss.passagem.mapper;

import com.example.abnerlucss.passagem.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.passagem.model.Passageiro;
import com.example.abnerlucss.passagem.model.Passagem;
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
