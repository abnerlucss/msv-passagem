package com.example.abnerlucss.passagem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {

    private LocalDateTime data;
    private String mensagem;
    private String causa;

    public ErrorObject(LocalDateTime data, String mensagem) {
        this.data = data;
        this.mensagem = mensagem;
    }
}
