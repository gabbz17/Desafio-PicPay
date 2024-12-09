package com.example.API_PicPay.controller;

import com.example.API_PicPay.service.LojistaService;
import com.example.API_PicPay.service.PessoaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/loja")
public class LojistaController {

    public final LojistaService lojistaService;
    public LojistaController(LojistaService lojistaService) {
        this.lojistaService = lojistaService;
    }


}
