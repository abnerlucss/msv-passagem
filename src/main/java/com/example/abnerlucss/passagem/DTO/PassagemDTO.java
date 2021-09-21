package com.example.abnerlucss.passagem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassagemDTO {

    private Integer idPassagem;

    private String partida;

    private String aeroporto;

    private String destino;

    private LocalDateTime dataHoraEmbarque;

    private LocalDateTime dataHoraDesembarque;

    private int numeroAssento;

    private String nomeClasse;

    private String nomeCompanhia;

    private Double preco;

    private Integer idVoo;

    public PassagemDTO(Integer idPassagem, String partida, String aeroporto, String destino, LocalDateTime dataHoraEmbarque, LocalDateTime dataHoraDesembarque, int numeroAssento, String nomeClasse, String nomeCompanhia, Double preco) {
        this.idPassagem = idPassagem;
        this.partida = partida;
        this.aeroporto = aeroporto;
        this.destino = destino;
        this.dataHoraEmbarque = dataHoraEmbarque;
        this.dataHoraDesembarque = dataHoraDesembarque;
        this.numeroAssento = numeroAssento;
        this.nomeClasse = nomeClasse;
        this.nomeCompanhia = nomeCompanhia;
        this.preco = preco;
    }
}
