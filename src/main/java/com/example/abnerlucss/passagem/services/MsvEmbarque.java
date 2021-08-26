package com.example.abnerlucss.passagem.services;

import com.example.abnerlucss.passagem.DTOs.EmbarqueDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "embarque" , url = "http://localhost:8081/v1/embarque")
public interface MsvEmbarque {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    boolean cadastrarPassagemComprada(@RequestBody EmbarqueDTO embarqueDTO);

}
