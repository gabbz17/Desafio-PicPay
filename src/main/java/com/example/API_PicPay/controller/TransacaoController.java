package com.example.API_PicPay.controller;

import com.example.API_PicPay.dto.TransacaoDTO;
import com.example.API_PicPay.dto.mapper.TransacaoMapper;
import com.example.API_PicPay.entity.Transacao;
import com.example.API_PicPay.exception.ErrorMessage;
import com.example.API_PicPay.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Transação", description = "Documentação de uma API de transações")
@Slf4j
@RestController
@RequestMapping("api/v1/transacao")
public class TransacaoController {

    public final TransacaoService service;
    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @Operation(summary = "Cria uma nova transação", description = "Http para criar uma nova transação",
            responses = {@ApiResponse(responseCode = "201", description = "Transação realizada com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "409", description = "Erro ao realizar transação!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody @Valid Transacao transacao){
        Transacao ts = service.create(transacao);
        return ResponseEntity.status(201).body(ts);
    }

    @Operation(summary = "Retorna todas as transações", description = "Http para retornar uma lista de transações",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao listar todas as transações", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao retornar lista de transações", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> findAll(){
        List<Transacao> list = service.findAll();
        List<TransacaoDTO> list1 = TransacaoMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @Operation(summary = "Retorna transações pelo email do Remetente", description = "Http para retornar transações pelo email do Remetente",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar todas as transações com o Remetente especificado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar transações com o Remetente especificado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @GetMapping("/email/remetente/{email}")
    public ResponseEntity<List<TransacaoDTO>> findByRemetente(@PathVariable @Valid String email){
        List<Transacao> list = service.findByRemetente(email);
        List<TransacaoDTO> list1 = TransacaoMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @Operation(summary = "Retorna transações pelo email do Destinatário", description = "Http para retornar transações pelo email do Destinatário",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar todas as transações com o Destinatário especificado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar transações com o Destinatário especificado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @GetMapping("/email/destinatario/{email}")
    public ResponseEntity<List<TransacaoDTO>> findByDestinatario(@PathVariable @Valid String email){
        List<Transacao> list = service.findByDestinatario(email);
        List<TransacaoDTO> list1 = TransacaoMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }


}
