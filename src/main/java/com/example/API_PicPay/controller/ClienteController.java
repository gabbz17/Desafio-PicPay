package com.example.API_PicPay.controller;

import com.example.API_PicPay.dto.ClienteDTO;
import com.example.API_PicPay.dto.SenhaDTO;
import com.example.API_PicPay.dto.mapper.ClienteMapper;
import com.example.API_PicPay.entity.Cliente;
import com.example.API_PicPay.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    public final ClienteService service;
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente){
        log.info("Gerando requisição para criar cliente: " + cliente);
        Cliente ps = service.create(cliente);
        return ResponseEntity.status(201).body(ps);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        log.info("Gerando requisição para listar clientes");
        List<Cliente> list = service.findAll();
        List<ClienteDTO> list1 = ClienteMapper.toAllDto(list);
        return ResponseEntity.ok().body(list1);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteDTO> findByEmail(@PathVariable @Valid String email){
        log.info("Gerando requisição para buscar cliente pelo email: " + email);
        Cliente pessoa = service.findByEmail(email);
        ClienteDTO dto = ClienteMapper.toDTO(pessoa);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable @Valid Long id){
        log.info("Gerando requisição para buscar cliente pelo id: " + id);
        Cliente cliente = service.findById(id);
        ClienteDTO dto = ClienteMapper.toDTO(cliente);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/delete/email/{email}")
    public ResponseEntity<Void> deleteByEmail(@PathVariable @Valid String email){
        log.info("Gerando requisição para deletar cliente pelo email: " + email);
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Cliente> updatePassword(@PathVariable Long id, @RequestBody @Valid SenhaDTO senhaDTO){
        Cliente cliente = service.updatePassword(id, senhaDTO.getSenhaAtual(), senhaDTO.getNovaSenha(), senhaDTO.getRepitaSenha());
        return ResponseEntity.ok().body(cliente);
    }
}
