package com.example.abnerlucss.passagem.service;

import com.example.abnerlucss.passagem.DTO.EmbarqueDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(name = "embarque" , url = "https://msv-embarque-production.up.railway.app/v1/embarque")
public interface MsvEmbarque {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    boolean cadastrarPassagemComprada(@RequestBody EmbarqueDTO embarqueDTO);

}
