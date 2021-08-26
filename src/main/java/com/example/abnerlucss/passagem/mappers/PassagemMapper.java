package com.example.abnerlucss.passagem.mappers;

import com.example.abnerlucss.passagem.DTOs.PassagemDTO;
import com.example.abnerlucss.passagem.models.Passagem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassagemMapper {

    public List<PassagemDTO> converterListaEntidadeParaDTO(List<Passagem> passagens) {

        return passagens.stream().map(passagem -> new PassagemDTO(
                passagem.getIdPassagem(),
                passagem.getAeroporto(),
                passagem.getDestino(),
                passagem.getDataHoraEmbarque(),
                passagem.getDataHoraDesembarque(),
                passagem.getNumeroAssento(),
                passagem.getClasse().getNome(),
                passagem.getCompanhiaAerea().getNome()
        )).collect(Collectors.toList());
    }
}