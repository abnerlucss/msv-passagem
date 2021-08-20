package com.example.abnerlucss.msvticket.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PassageiroDTO {

    private Integer id;

    @NotNull
    @Length(max = 150)
    private String nome;

    @Length(max = 9)
    private String rg;

    @CPF
    private String cpf;

    @Email
    private String email;

    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private Date dataNascimento;

    public PassageiroDTO(String nome, String rg, String cpf, String email, String telefone, Date dataNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }
}
