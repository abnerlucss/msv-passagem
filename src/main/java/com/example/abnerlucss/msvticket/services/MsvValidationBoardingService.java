package com.example.abnerlucss.msvticket.services;

import com.example.abnerlucss.msvticket.DTOs.EmbarqueDTO;
import com.example.abnerlucss.msvticket.DTOs.PassagemCompradaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "passagem" , url = "http://localhost:8081/v1/embarque")
public interface MsvValidationBoardingService {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    boolean cadastrarPassagemComprada(@RequestBody EmbarqueDTO embarqueDTO);

}
