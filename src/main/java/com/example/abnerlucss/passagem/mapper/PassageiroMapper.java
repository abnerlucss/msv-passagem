package com.example.abnerlucss.passagem.mapper;

import com.example.abnerlucss.passagem.DTO.PassageiroDTO;
import com.example.abnerlucss.passagem.model.Passageiro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassageiroMapper {
    public Passageiro converteDTOParaEntidade(PassageiroDTO passageiroDTO) {
        return new Passageiro(
                passageiroDTO.getId(),
                passageiroDTO.getNome(),
                passageiroDTO.getRg(),
                passageiroDTO.getCpf(),
                passageiroDTO.getEmail(),
                passageiroDTO.getTelefone(),
                passageiroDTO.getDataNascimento()
        );
    }

    public List<PassageiroDTO> converteListaDeEntidadeParaDTO(List<Passageiro> passageiroList) {
        return passageiroList.stream().map(passageiro -> PassageiroDTO.builder()
                .id(passageiro.getIdPassageiro())
                .nome(passageiro.getNome())
                .rg(passageiro.getRg())
                .cpf(passageiro.getCpf())
                .email(passageiro.getEmail())
                .telefone(passageiro.getTelefone())
                .dataNascimento(passageiro.getDataNascimento())
                .build()
        ).collect(Collectors.toList());

    }

    public PassageiroDTO converteEntidadeParaDTO(Passageiro passageiro) {
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
