package com.example.abnerlucss.passagem.service;

import com.example.abnerlucss.passagem.DTO.*;
import com.example.abnerlucss.passagem.exception.CreateException;
import com.example.abnerlucss.passagem.exception.ListException;
import com.example.abnerlucss.passagem.exception.NotFoundException;
import com.example.abnerlucss.passagem.mapper.EmbarqueMapper;
import com.example.abnerlucss.passagem.mapper.PassagemCompradaMapper;
import com.example.abnerlucss.passagem.mapper.PassagemMapper;
import com.example.abnerlucss.passagem.model.Passageiro;
import com.example.abnerlucss.passagem.model.Passagem;
import com.example.abnerlucss.passagem.repository.ClasseRepository;
import com.example.abnerlucss.passagem.repository.CompanhiaAereaRepository;
import com.example.abnerlucss.passagem.repository.PassageiroRepository;
import com.example.abnerlucss.passagem.repository.PassagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@SuppressWarnings("unused")
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private CompanhiaAereaRepository companhiaAereaRepository;

    @Autowired
    private MsvEmbarque msvEmbarque;

    private final PassagemMapper passagemMapper;

    private final PassagemCompradaMapper passagemCompradaMapper;

    private final EmbarqueMapper embarqueMapper;


    public List<PassagemDTO> listarPassagensDisponiveis() {
        List<Passagem> passagens = passagemRepository.findAllPassagensDisponiveis();
        return passagemMapper.converterListaEntidadeParaDTO(passagens);
    }

    public PassagemCompradaDTO comprarPassagem(DadosCompraDTO body) throws NotFoundException, CreateException {

        Passagem passagem = passagemRepository.findById(body.getIdPassagem()).orElseThrow(
                () -> new NotFoundException("Passagem não econtrada"));
        Passageiro passageiro = passageiroRepository.findById(body.getIdPassageiro()).orElseThrow(
                () -> new NotFoundException("Passageiro não encontrado")
        );

        try {
            passagem.setPassageiro(passageiro);

            passagemRepository.save(passagem);

            PassagemCompradaDTO novaPassagemComprada = passagemCompradaMapper.converteEntidadeParaDTO(passageiro, passagem);

            EmbarqueDTO embarqueDTO = embarqueMapper.converteEntidadeParaDTO(novaPassagemComprada, passagem);

            if (msvEmbarque.cadastrarPassagemComprada(embarqueDTO)) {
                return novaPassagemComprada;
            } else {
                throw new CreateException("Não foi possível comprar passagem");
            }

        } catch (Exception e) {
            throw new CreateException("Não foi possível comprar passagem");

        }
    }

    public List<PassagemDTO> cadastrarPassagem(VooDTO body) throws CreateException {
        try {
            List<Passagem> passagemLista = new ArrayList<>();

            Integer numAssento = 1;

            for (int index = 1; index <= body.getQtdEconomica(); index++) {
                passagemLista.add(passagemRepository.save(
                        new Passagem(
                                body.getAeroporto(),
                                body.getDestino(),
                                body.getDataHoraEmbarque(),
                                body.getDataHoraDesembarque(),
                                numAssento,
                                null,
                                classeRepository.findByNome("Econômica"),
                                companhiaAereaRepository.findByIdentificadorComp(body.getIdentificadorCompanhia()),
                                body.getPrecoEconomica(),
                                body.getPartida(),
                                body.getIdVoo()
                        )
                ));
                numAssento++;
            }

            for (int index = 1; index <= body.getQtdExecutiva(); index++) {
                passagemLista.add(passagemRepository.save(
                        new Passagem(
                                body.getAeroporto(),
                                body.getDestino(),
                                body.getDataHoraEmbarque(),
                                body.getDataHoraDesembarque(),
                                numAssento,
                                null,
                                classeRepository.findByNome("Executiva"),
                                companhiaAereaRepository.findByIdentificadorComp(body.getIdentificadorCompanhia()),
                                body.getPrecoExecutiva(),
                                body.getPartida(),
                                body.getIdVoo()
                        )
                ));
                numAssento++;
            }

            for (int index = 1; index <= body.getQtdPrimeiraClasse(); index++) {
                passagemLista.add(passagemRepository.save(
                        new Passagem(
                                body.getAeroporto(),
                                body.getDestino(),
                                body.getDataHoraEmbarque(),
                                body.getDataHoraDesembarque(),
                                numAssento,
                                null,
                                classeRepository.findByNome("Primeira Classe"),
                                companhiaAereaRepository.findByIdentificadorComp(body.getIdentificadorCompanhia()),
                                body.getPrecoPrimeiraClasse(),
                                body.getPartida(),
                                body.getIdVoo()
                        )
                ));
                numAssento++;
            }

            return passagemMapper.converterListaEntidadeParaDTO(passagemLista);

        } catch (Exception e) {
            throw new CreateException("Erro ao cadastrar as passagens", e.getCause());
        }
    }

    public List<PassagemDTO> listarPassagensPorIdVoo(Integer idVoo) throws ListException {
        try {
            return passagemMapper.converterListaEntidadeParaDTO(passagemRepository.findAllPassagensDisponiveisByIdVoo(idVoo));
        } catch (Exception e) {
            throw new ListException("Erro ao listar passagens onde o Id do voo é " + idVoo);
        }
    }

    public List<PassagemDTO> listarPassagensDisponiveisPorIdVoo(Integer idVoo) throws ListException {
        try {
            return passagemMapper.converterListaEntidadeParaDTO(passagemRepository.findAllPassagensDisponiveisPorVoo(idVoo));

        } catch (Exception e) {
            throw new ListException("Falha ao listar passagens disponíveis para o voo " + idVoo);
        }
    }

    public List<PassagemDTO> listarPassagensIndisponiveisPorIdVoo(Integer idVoo) throws ListException {
        try {
            return passagemMapper.converterListaEntidadeParaDTO(passagemRepository.findAllPassagensIndisponiveis(idVoo));
        } catch (Exception e) {
            throw new ListException("Falha ao listar passagens indisponíveis para o voo " + idVoo);
        }
    }

    public List<PassagemDTO> listarPassagensIndisponiveis() throws ListException {
        try {
            return passagemMapper.converterListaEntidadeParaDTO(passagemRepository.findAllPassagensIndisponiveis());
        } catch (Exception e) {
            throw new ListException("Falha ao listar passagens indisponíveis");
        }
    }

    public List<PassagemDTO> listarPassagensPorIdVooClasse(Integer idVoo, String classe) throws ListException {
        try {
            return passagemMapper.converterListaEntidadeParaDTO(passagemRepository.listarPassagensPorIdVooClasse(idVoo, classe));
        } catch (Exception e) {
            throw new ListException("Falha ao listar passagens indisponíveis");
        }
    }
}
