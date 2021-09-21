package com.example.abnerlucss.passagem.service;

import com.example.abnerlucss.passagem.DTO.LoginDTO;
import com.example.abnerlucss.passagem.DTO.PassageiroDTO;
import com.example.abnerlucss.passagem.exception.*;
import com.example.abnerlucss.passagem.mapper.PassageiroMapper;
import com.example.abnerlucss.passagem.model.Passageiro;
import com.example.abnerlucss.passagem.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private PassageiroMapper passageiroMapper;

    public PassageiroDTO cadastrarPassageiro(PassageiroDTO passageiroDTO) throws CreateException {
        try {
            return passageiroMapper.converteEntidadeParaDTO(passageiroRepository.save(passageiroMapper.converteDTOParaEntidade(passageiroDTO)));
        } catch (Exception e) {
            throw new CreateException("Falha ao cadastrar passageiro", e.getCause());
        }
    }

    public List<PassageiroDTO> listarPassageiros() throws ListException {
        try {
            return passageiroMapper.converteListaDeEntidadeParaDTO(passageiroRepository.findAll());

        } catch (Exception e) {
            throw new ListException("Falha ao listar passageiros", e.getCause());
        }
    }

    public PassageiroDTO buscarPassageiroPorCpf(String cpf) throws NotFoundException, ConvertException {
        Passageiro passageiro = passageiroRepository.findByCpf(cpf).orElseThrow(
                () -> new NotFoundException("Passageiro não encontrado")
        );

        try {
            return passageiroMapper.converteEntidadeParaDTO(passageiro);

        } catch (Exception e) {
            throw new ConvertException("Erro ao buscar passageiro", e.getCause());
        }

    }

    public PassageiroDTO buscarPassageiroPorId(Integer id) throws NotFoundException, ConvertException {
        Passageiro passageiro = passageiroRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Passageiro não encontrado")
        );

        try {
            return passageiroMapper.converteEntidadeParaDTO(passageiro);
        } catch (Exception e) {
            throw new ConvertException("Erro ao buscar passageiro", e.getCause());
        }
    }

    public String excluirPassageiroPorId(Integer id) throws DeleteException {
        try {
            passageiroRepository.deleteById(id);
            return "Passageiro excluído com sucesso";

        } catch (Exception e) {
            throw new DeleteException("Não foi possível excluir o passageiro");

        }
    }

    public String excluirPassageiroPorCpf(String cpf) throws DeleteException, NotFoundException {
        Passageiro passageiro = passageiroRepository.findByCpf(cpf).orElseThrow(
                () -> new NotFoundException("Passageiro não encontrado")
        );

        try {
            passageiroRepository.delete(passageiro);
            return "Passageiro excluído com sucesso";

        } catch (Exception e) {
            throw new DeleteException("Não foi possível excluir o passageiro");

        }
    }

    public PassageiroDTO atualizarPassageiro(Integer id, PassageiroDTO body) throws NotFoundException, UpdateException {

        passageiroRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Passageiro não encontrado")
        );

        try {
            Passageiro passageiro = passageiroMapper.converteDTOParaEntidade(body);

            passageiro.setIdPassageiro(id);

            return passageiroMapper.converteEntidadeParaDTO(passageiroRepository.save(passageiro));

        } catch (Exception e) {
            throw new UpdateException(("Erro ao atualizar passageiro: " + id), e.getCause());
        }
    }

    public PassageiroDTO atualizarPassageiro(String cpf, PassageiroDTO body) throws NotFoundException, UpdateException {
        Passageiro p = passageiroRepository.findByCpf(cpf).orElseThrow(
                () -> new NotFoundException("Passageiro não encontrado")
        );

        try {
            Passageiro passageiro = passageiroMapper.converteDTOParaEntidade(body);

            passageiro.setIdPassageiro(p.getIdPassageiro());

            return passageiroMapper.converteEntidadeParaDTO(passageiroRepository.save(passageiro));

        } catch (Exception e) {
            throw new UpdateException(("Erro ao atualizar passageiro: " + cpf), e.getCause());
        }
    }

    public Integer loginPassageiro(LoginDTO body) throws NotFoundException {
        Passageiro passageiro = passageiroRepository.loginPassageiro(body.getCpf(), body.getSenha()).orElse(null);

        if (passageiro != null)
            return passageiro.getIdPassageiro();
        throw new NotFoundException("Cpf e/ou senha inválido(s)");

    }
}
