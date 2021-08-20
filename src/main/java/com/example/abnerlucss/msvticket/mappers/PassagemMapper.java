package com.example.abnerlucss.msvticket.mappers;

import com.example.abnerlucss.msvticket.DTOs.CadPassagemDTO;
import com.example.abnerlucss.msvticket.DTOs.PassagemCompradaDTO;
import com.example.abnerlucss.msvticket.DTOs.PassagemDTO;
import com.example.abnerlucss.msvticket.models.Classe;
import com.example.abnerlucss.msvticket.models.CompanhiaAerea;
import com.example.abnerlucss.msvticket.models.Passageiro;
import com.example.abnerlucss.msvticket.models.Passagem;
import com.example.abnerlucss.msvticket.util.Codificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassagemMapper {

    public List<PassagemDTO> converterListaEntidadeParaDTO(List<Passagem> passagens){

        return passagens.stream().map(passagem -> new PassagemDTO(
                passagem.getIdPassagem(),
                passagem.getAeroporto(),
                passagem.getDestino(),
                passagem.getDataEmbarque(),
                passagem.getHoraEmbarque(),
                passagem.getHoraDesembarque(),
                passagem.getNumeroAssento(),
                passagem.getClasse().getNome(),
                passagem.getCompanhiaAerea().getNome()
        )).collect(Collectors.toList());
    }

    public PassagemDTO converterEntidadeParaDTO(Passagem passagem, Classe classe, CompanhiaAerea companhiaAerea) {
        return new PassagemDTO(
                passagem.getIdPassagem(),
                passagem.getAeroporto(),
                passagem.getDestino(),
                passagem.getDataEmbarque(),
                passagem.getHoraEmbarque(),
                passagem.getHoraDesembarque(),
                passagem.getNumeroAssento(),
                classe.getNome(),
                companhiaAerea.getNome()
        );
    }

    public Passagem converterDTOParaEntidade(CadPassagemDTO cadPassagemDTO, Classe classe, CompanhiaAerea companhiaAerea) {
        return new Passagem(
                cadPassagemDTO.getAeroporto(),
                cadPassagemDTO.getDestino(),
                cadPassagemDTO.getDataEmbarque(),
                cadPassagemDTO.getHoraEmbarque(),
                cadPassagemDTO.getHoraDesembarque(),
                cadPassagemDTO.getNumeroAssento(),
                null,
                classe,
                companhiaAerea
        );
    }

}
