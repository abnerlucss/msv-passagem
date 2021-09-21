package com.example.abnerlucss.passagem.mapper;

import com.example.abnerlucss.passagem.DTO.PassagemDTO;
import com.example.abnerlucss.passagem.model.Passagem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassagemMapper {

    public List<PassagemDTO> converterListaEntidadeParaDTO(List<Passagem> passagens) {

        return passagens.stream().map(passagem -> new PassagemDTO(
                passagem.getIdPassagem(),
                passagem.getPartida(),
                passagem.getAeroporto(),
                passagem.getDestino(),
                passagem.getDataHoraEmbarque(),
                passagem.getDataHoraDesembarque(),
                passagem.getNumeroAssento(),
                passagem.getClasse().getNome(),
                passagem.getCompanhiaAerea().getNome(),
                passagem.getPreco(),
                passagem.getIdVoo()

        )).collect(Collectors.toList());
    }
}
