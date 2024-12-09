package com.example.API_PicPay.controller;

import com.example.API_PicPay.dto.TransacaoDTO;
import com.example.API_PicPay.dto.mapper.TransacaoMapper;
import com.example.API_PicPay.entity.Transacao;
import com.example.API_PicPay.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/transacao")
public class TransacaoController {

    public final TransacaoService service;
    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody @Valid Transacao transacao){
        Transacao ts = service.create(transacao);
        return ResponseEntity.status(201).body(ts);
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> findAll(){
        List<Transacao> list = service.findAll();
        List<TransacaoDTO> list1 = TransacaoMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @GetMapping("/email/remetente/{email}")
    public ResponseEntity<List<TransacaoDTO>> findByRemetente(@PathVariable @Valid String email){
        List<Transacao> list = service.findByRemetente(email);
        List<TransacaoDTO> list1 = TransacaoMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @GetMapping("/email/destinatario/{email}")
    public ResponseEntity<List<TransacaoDTO>> findByDestinatario(@PathVariable @Valid String email){
        List<Transacao> list = service.findByDestinatario(email);
        List<TransacaoDTO> list1 = TransacaoMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }


}
