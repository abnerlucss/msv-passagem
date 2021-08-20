package com.example.abnerlucss.msvticket.mappers;

import com.example.abnerlucss.msvticket.DTOs.PassageiroDTO;
import com.example.abnerlucss.msvticket.models.Passageiro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassageiroMapper {
    public Passageiro converterDTOParaEntidade(PassageiroDTO passageiroDTO) {
        return new Passageiro(
                passageiroDTO.getNome(),
                passageiroDTO.getRg(),
                passageiroDTO.getCpf(),
                passageiroDTO.getEmail(),
                passageiroDTO.getTelefone(),
                passageiroDTO.getDataNascimento()
        );
    }

    public Passageiro atualizaEntidadePorDTO(Passageiro passageiro, PassageiroDTO passageiroDTO) {
        passageiro.setNome(passageiroDTO.getNome());
        passageiro.setRg(passageiroDTO.getRg());
        passageiro.setCpf(passageiroDTO.getCpf());
        passageiro.setEmail(passageiroDTO.getEmail());
        passageiro.setTelefone(passageiroDTO.getTelefone());
        passageiro.setDataNascimento(passageiroDTO.getDataNascimento());

        return passageiro;
    }


    public List<PassageiroDTO> converterListaDeEntidadeParaDTO(List<Passageiro> passageiroList) {
        return passageiroList.stream().map(passageiro -> new PassageiroDTO(
                passageiro.getIdPassageiro(),
                passageiro.getNome(),
                passageiro.getRg(),
                passageiro.getCpf(),
                passageiro.getEmail(),
                passageiro.getTelefone(),
                passageiro.getDataNascimento()
        )).collect(Collectors.toList());
    }

    public PassageiroDTO converterEntidadeParaDTO(Passageiro passageiro) {
        return new PassageiroDTO(
                passageiro.getIdPassageiro(),
                passageiro.getNome(),
                passageiro.getRg(),
                passageiro.getCpf(),
                passageiro.getEmail(),
                passageiro.getTelefone(),
                passageiro.getDataNascimento()
        );
    }
}
