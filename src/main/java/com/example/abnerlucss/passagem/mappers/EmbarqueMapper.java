package com.example.abnerlucss.passagem.mappers;

import com.example.abnerlucss.passagem.DTOs.EmbarqueDTO;
import com.example.abnerlucss.passagem.DTOs.PassagemCompradaDTO;
import com.example.abnerlucss.passagem.models.Passagem;
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
