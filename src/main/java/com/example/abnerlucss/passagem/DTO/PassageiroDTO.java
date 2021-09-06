package com.example.abnerlucss.passagem.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PassageiroDTO {

    private Integer id;

    @NotNull
    @Length(max = 150)
    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataNascimento;

    private String senha;


    public PassageiroDTO(Integer id, String nome, String cpf, String email, String telefone, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }
}
