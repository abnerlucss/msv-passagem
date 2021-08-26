package com.example.abnerlucss.passagem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classe")
public class Classe {

    @Id
    @GeneratedValue
    @Column(name = "id_classe")
    private Integer idClasse;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

}
