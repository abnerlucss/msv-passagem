package com.example.abnerlucss.msvticket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "passageiro")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passageiro")
    private Integer idPassageiro;

    @Column(name = "nome")
    private String nome;

    @Column(name = "rg", unique = true)
    private String rg;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    public Passageiro(String nome, String rg, String cpf, String email, String telefone, Date dataNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }
}
