package com.example.abnerlucss.passagem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passagem")
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passagem")
    private Integer idPassagem;

    @Column(name = "aeroporto")
    private String aeroporto;

    @Column(name = "destino")
    private String destino;

    @Column(name = "data_hora_embarque")
    private LocalDateTime dataHoraEmbarque;

    @Column(name = "data_hora_desembarque")
    private LocalDateTime dataHoraDesembarque;

    @Column(name = "numero_assento")
    private int numeroAssento;

    @ManyToOne
    @JoinColumn(name = "id_passageiro")
    private Passageiro passageiro;

    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "id_companhia_aerea")
    private CompanhiaAerea companhiaAerea;

    public Passagem(String aeroporto, String destino, LocalDateTime dataHoraEmbarque, LocalDateTime dataHoraDesembarque, int numeroAssento, Passageiro passageiro, Classe classe, CompanhiaAerea companhiaAerea) {
        this.aeroporto = aeroporto;
        this.destino = destino;
        this.dataHoraEmbarque = dataHoraEmbarque;
        this.dataHoraDesembarque = dataHoraDesembarque;
        this.numeroAssento = numeroAssento;
        this.passageiro = passageiro;
        this.classe = classe;
        this.companhiaAerea = companhiaAerea;
    }

}
