package com.example.abnerlucss.passagem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
    private String cpf;
    private String senha;
}
