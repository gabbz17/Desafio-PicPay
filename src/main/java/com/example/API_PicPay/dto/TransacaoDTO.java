package com.example.API_PicPay.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoDTO(
        Long id,
        String remetente,
        String destinatario,
        BigDecimal valor,
        LocalDateTime horaTransacao
) {
}
