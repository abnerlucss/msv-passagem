package com.example.abnerlucss.msvticket.services;

import com.example.abnerlucss.msvticket.DTOs.PassageiroDTO;
import com.example.abnerlucss.msvticket.exceptions.CreateException;
import com.example.abnerlucss.msvticket.exceptions.DeleteException;
import com.example.abnerlucss.msvticket.exceptions.NotFoundException;
import com.example.abnerlucss.msvticket.exceptions.UpdateException;
import com.example.abnerlucss.msvticket.mappers.PassageiroMapper;
import com.example.abnerlucss.msvticket.models.Passageiro;
import com.example.abnerlucss.msvticket.repositories.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private PassageiroMapper passageiroMapper;

    public PassageiroDTO cadastrarPassageiro(PassageiroDTO passageiroDTO) throws CreateException {
        try{
            return passageiroMapper.converterEntidadeParaDTO(passageiroRepository.save(passageiroMapper.converterDTOParaEntidade(passageiroDTO)));
        }
        catch (Exception e){
            throw new CreateException("Falha ao cadastrar passageiro", e.getCause());
        }
    }


    public List<PassageiroDTO> listarPassageiros() {
        return passageiroMapper.converterListaDeEntidadeParaDTO(passageiroRepository.findAll());
    }

    public PassageiroDTO buscarPassageiroPorCpf(String cpf) throws NotFoundException {
        Optional<Passageiro> passageiro = passageiroRepository.findByCpf(cpf);

        if(!passageiro.isPresent())
            throw new NotFoundException("Passageiro não encontrado");

        return passageiroMapper.converterEntidadeParaDTO(passageiro.get());

    }


    public PassageiroDTO buscarPassageiroPorId(Integer id) throws NotFoundException {
        return passageiroMapper.converterEntidadeParaDTO(
                passageiroRepository.findById(id).orElseThrow( ()->
                        new NotFoundException("Passageiro não encontrado")
                )
        );
    }

    public String excluirPassageiroPorId(Integer id) throws DeleteException{
        try {
            passageiroRepository.deleteById(id);
            return "Passageiro excluído com sucesso";
        }
        catch (Exception e){
            throw new DeleteException("Não foi possível excluir o passageiro");
        }
    }

    public String excluirPassageiroPorCpf(String cpf) throws DeleteException, NotFoundException {
        Optional<Passageiro> passageiro = passageiroRepository.findByCpf(cpf);

        if(!passageiro.isPresent())
                throw new NotFoundException("Passageiro não encontrado");

        try {
            passageiroRepository.delete(passageiro.get());
            return "Passageiro excluído com sucesso";
        }
        catch (Exception e){
            throw new DeleteException("Não foi possível excluir o passageiro");
        }
    }

    public PassageiroDTO atualizarPassageiro(Integer id, PassageiroDTO body) throws NotFoundException, UpdateException {
        Passageiro passageiro = passageiroRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Passageiro não encontrado")
        );

        try {
            passageiro = passageiroMapper.atualizaEntidadePorDTO(passageiro, body);
            return passageiroMapper.converterEntidadeParaDTO(passageiroRepository.save(passageiro));
        }
        catch (Exception e){
            throw new UpdateException(("Erro ao atualizar passageiro: " + id), e.getCause());
        }
    }

    public PassageiroDTO atualizarPassageiro(String cpf, PassageiroDTO body) throws NotFoundException, UpdateException {
        Optional<Passageiro> passageiro = passageiroRepository.findByCpf(cpf);

        if(!passageiro.isPresent())
            throw new NotFoundException("Passageiro não encontrado");

        try {
            return passageiroMapper.converterEntidadeParaDTO(passageiroRepository.save(passageiroMapper.atualizaEntidadePorDTO(passageiro.get(), body)));
        }
        catch (Exception e){
            throw new UpdateException(("Erro ao atualizar passageiro: " + passageiro.get().getIdPassageiro()), e.getCause());
        }
    }
}
