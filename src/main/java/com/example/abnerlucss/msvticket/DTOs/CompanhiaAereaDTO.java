package com.example.abnerlucss.msvticket.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanhiaAereaDTO {
    private Integer id;
    private String nome;
    private String codigo;
    private String identificadorComp;
}
