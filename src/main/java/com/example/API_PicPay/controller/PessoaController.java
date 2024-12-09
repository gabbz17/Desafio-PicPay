package com.example.API_PicPay.controller;

import com.example.API_PicPay.dto.PessoaDTO;
import com.example.API_PicPay.dto.mapper.PessoaMapper;
import com.example.API_PicPay.entity.Pessoa;
import com.example.API_PicPay.service.PessoaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaController {

    public final PessoaService pessoaService;
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa){
        log.info("Gerando requisição para criar pessoa: " + pessoa);
        Pessoa ps = pessoaService.create(pessoa);
        return ResponseEntity.status(201).body(ps);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        log.info("Gerando requisição para listar pessoas");
        List<Pessoa> list = pessoaService.findAll();
        List<PessoaDTO> list1 = PessoaMapper.toAllPessoaDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PessoaDTO> findByEmail(@PathVariable @Valid String email){
        log.info("Gerando requisição para buscar pessoa pelo email: " + email);
        Pessoa pessoa = pessoaService.findByEmail(email);
        PessoaDTO dto = PessoaMapper.toPessoaDTO(pessoa);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable @Valid Long id){
        log.info("Gerando requisição para buscar pessoa pelo id: " + id);
        Pessoa pessoa = pessoaService.findById(id);
        PessoaDTO dto = PessoaMapper.toPessoaDTO(pessoa);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("delete/email/{email}")
    public ResponseEntity<Void> deleteByEmail(@PathVariable @Valid String email){
        log.info("Gerando requisição para deletar pessoa pelo email: " + email);
        pessoaService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
