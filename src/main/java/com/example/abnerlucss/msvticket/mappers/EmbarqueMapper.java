package com.example.abnerlucss.msvticket.mappers;

import com.example.abnerlucss.msvticket.DTOs.EmbarqueDTO;
import com.example.abnerlucss.msvticket.DTOs.PassagemCompradaDTO;
import com.example.abnerlucss.msvticket.models.Passageiro;
import com.example.abnerlucss.msvticket.models.Passagem;
import org.springframework.stereotype.Component;

@Component
public class EmbarqueMapper {

    public EmbarqueDTO converteEntidadeParaDTO(PassagemCompradaDTO passagemCompradaDTO, Passagem passagem, Passageiro passageiro){
        return new EmbarqueDTO(
                passagem.getDataEmbarque(),
                passagem.getHoraEmbarque(),
                passagem.getClasse().getNome(),
                passagemCompradaDTO.getCodigoLocalizador(),
                passagem.getCompanhiaAerea().getIdentificadorComp(),
                passagem.getNumeroAssento(),
                passagem.getDestino()
        );
    }

}
