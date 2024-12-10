package com.example.API_PicPay.controller;

import com.example.API_PicPay.dto.ClienteDTO;
import com.example.API_PicPay.dto.SenhaDTO;
import com.example.API_PicPay.dto.mapper.ClienteMapper;
import com.example.API_PicPay.entity.Cliente;
import com.example.API_PicPay.exception.ErrorMessage;
import com.example.API_PicPay.service.ClienteService;
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

@Tag(name = "Clientes", description = "Documentação de uma API completa de Clientes")
@Slf4j
@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    public final ClienteService service;
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @Operation(summary = "Cria um novo cliente", description = "Http para criar um novo Cliente",
    responses = {@ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
    @ApiResponse(responseCode = "409", description = "Erro ao cadastrar Cliente!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente){
        log.info("Gerando requisição para criar cliente: " + cliente);
        Cliente ps = service.create(cliente);
        return ResponseEntity.status(201).body(ps);
    }

    @Operation(summary = "Retorna todos os clientes", description = "Http para retornar uma lista de clientes",
    responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao listar todos os clientes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
    @ApiResponse(responseCode = "404", description = "Erro ao retornar lista de clientes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        log.info("Gerando requisição para listar clientes");
        List<Cliente> list = service.findAll();
        List<ClienteDTO> list1 = ClienteMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @Operation(summary = "Retorna cliente pelo email", description = "Http para retornar um cliente pelo email",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteDTO> findByEmail(@PathVariable @Valid String email){
        log.info("Gerando requisição para buscar cliente pelo email: " + email);
        Cliente pessoa = service.findByEmail(email);
        ClienteDTO dto = ClienteMapper.toDTO(pessoa);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(summary = "Retorna cliente pelo id", description = "Http para retornar um cliente pelo id",
            responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao buscar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Erro ao buscar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @GetMapping("/id/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable @Valid Long id){
        log.info("Gerando requisição para buscar cliente pelo id: " + id);
        Cliente cliente = service.findById(id);
        ClienteDTO dto = ClienteMapper.toDTO(cliente);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(summary = "Deleta cliente pelo email", description = "Http para deletar cliente pelo email",
    responses = {@ApiResponse(responseCode = "200", description = "Sucesso ao deletar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
    @ApiResponse(responseCode = "204", description = "Erro ao deletar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @DeleteMapping("/delete/email/{email}")
    public ResponseEntity<Void> deleteByEmail(@PathVariable @Valid String email){
        log.info("Gerando requisição para deletar cliente pelo email: " + email);
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Altera senha do cliente pelo id", description = "Http para alterar senha pelo id",
            responses = {@ApiResponse(responseCode = "201", description = "Sucesso ao alterar senha", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "204", description = "Erro ao alterar senha", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PatchMapping("/update/{id}")
    public ResponseEntity<Cliente> updatePassword(@PathVariable Long id, @RequestBody @Valid SenhaDTO senhaDTO){
        Cliente cliente = service.updatePassword(id, senhaDTO.getSenhaAtual(), senhaDTO.getNovaSenha(), senhaDTO.getRepitaSenha());
        return ResponseEntity.ok().body(cliente);
    }
}
