package com.example.abnerlucss.passagem.mapper;

import com.example.abnerlucss.passagem.DTO.EmbarqueDTO;
import com.example.abnerlucss.passagem.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.passagem.model.Passagem;
import org.springframework.stereotype.Component;

@Component
public class EmbarqueMapper {

    public EmbarqueDTO converteEntidadeParaDTO(PassagemCompradaDTO passagemCompradaDTO, Passagem passagem) {
        return new EmbarqueDTO(
                passagem.getDataHoraEmbarque(),
                passagem.getClasse().getNome(),
                passagemCompradaDTO.getCodigoLocalizador(),
                passagem.getCompanhiaAerea().getIdentificadorComp(),
                passagem.getNumeroAssento(),
                passagem.getDestino()
        );
    }

}
