package com.example.API_PicPay.dto.mapper;

import com.example.API_PicPay.dto.ClienteDTO;
import com.example.API_PicPay.dto.TransacaoDTO;
import com.example.API_PicPay.entity.Cliente;
import com.example.API_PicPay.entity.Transacao;

import java.util.List;

public class TransacaoMapper {

    public static TransacaoDTO toDTO(Transacao transacao){
        return new TransacaoDTO(transacao.getId(), transacao.getRemetente(), transacao.getDestinatario(), transacao.getValor(), transacao.getHoraTransacao());
    }

    public static List<TransacaoDTO> toAllDto(List<Transacao> pessoa){
        return pessoa.stream().map(TransacaoMapper::toDTO).toList();
    }
}
