package com.example.abnerlucss.msvticket.models;

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
@Table(name = "companhia_aerea")
public class CompanhiaAerea {

    @Id
    @GeneratedValue
    @Column(name = "id_companhia_aerea")
    private Integer idCompanhiaAerea;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo", unique = true)
    private String codigo;

    @Column(name = "identificador_comp", unique = true)
    private String identificadorComp;

}
