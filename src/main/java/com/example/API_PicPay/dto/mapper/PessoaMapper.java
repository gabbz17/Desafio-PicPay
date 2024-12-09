package com.example.API_PicPay.dto.mapper;

import com.example.API_PicPay.dto.PessoaDTO;
import com.example.API_PicPay.entity.Pessoa;

import java.util.List;

public class PessoaMapper {

    public static PessoaDTO toPessoaDTO(Pessoa pessoa){
        return new PessoaDTO(pessoa.getId(), pessoa.getNomeCompleto(), pessoa.getSaldo(), pessoa.getRole());
    }

    public static List<PessoaDTO> toAllPessoaDto(List<Pessoa> pessoa){
        return pessoa.stream().map(PessoaMapper::toPessoaDTO).toList();
    }
}
