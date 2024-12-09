package com.example.API_PicPay.service;

import com.example.API_PicPay.repository.LojistaRepository;
import org.springframework.stereotype.Service;

@Service
public class LojistaService {

    public final LojistaRepository lojistaRepository;
    public LojistaService(LojistaRepository lojistaRepository) {
        this.lojistaRepository = lojistaRepository;
    }


}
