package com.example.abnerlucss.msvticket.DTO;

import com.example.abnerlucss.msvticket.models.Passagem;

import java.util.Date;

public class ComprovanteDTO {
    private String nome_passageiro;
    private String cpf;
    private int codigo_localizador;

    public ComprovanteDTO(String nome_passageiro, String cpf, int codigo_localizador) {
        this.nome_passageiro = nome_passageiro;
        this.cpf = cpf;
        this.codigo_localizador = codigo_localizador;
    }

    public String getNome_passageiro() {
        return nome_passageiro;
    }

    public void setNome_passageiro(String nome_passageiro) {
        this.nome_passageiro = nome_passageiro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodigo_localizador() {
        return codigo_localizador;
    }

    public void setCodigo_localizador(int codigo_localizador) {
        this.codigo_localizador = codigo_localizador;
    }
}
