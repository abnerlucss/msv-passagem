package com.example.abnerlucss.msvticket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "data_embarque")
    private Date dataEmbarque;

    @Column(name = "hora_embarque")
    private Date horaEmbarque;

    @Column(name = "hora_desembarque")
    private Date horaDesembarque;

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

    public Passagem(String aeroporto, String destino, Date dataEmbarque, Date horaEmbarque, Date horaDesembarque, int numeroAssento, Passageiro passageiro, Classe classe, CompanhiaAerea companhiaAerea) {
        this.aeroporto = aeroporto;
        this.destino = destino;
        this.dataEmbarque = dataEmbarque;
        this.horaEmbarque = horaEmbarque;
        this.horaDesembarque = horaDesembarque;
        this.numeroAssento = numeroAssento;
        this.passageiro = passageiro;
        this.classe = classe;
        this.companhiaAerea = companhiaAerea;
    }
}
