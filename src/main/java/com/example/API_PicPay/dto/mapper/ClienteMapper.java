package com.example.API_PicPay.dto.mapper;

import com.example.API_PicPay.dto.ClienteDTO;
import com.example.API_PicPay.entity.Cliente;

import java.util.List;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(cliente.getId(), cliente.getNomeCompleto(), cliente.getSaldo(), cliente.getRole());
    }

    public static List<ClienteDTO> toAllDto(List<Cliente> pessoa){
        return pessoa.stream().map(ClienteMapper::toDTO).toList();
    }
}
