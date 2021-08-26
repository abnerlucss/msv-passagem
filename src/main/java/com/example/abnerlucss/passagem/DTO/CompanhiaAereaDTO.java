package com.example.abnerlucss.passagem.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanhiaAereaDTO {
    private Integer id;
    private String nome;
    private String codigo;
    private String identificadorComp;
}
