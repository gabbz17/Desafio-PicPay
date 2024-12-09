package com.example.API_PicPay.dto;

import com.example.API_PicPay.entity.Role;

import java.math.BigDecimal;

public record ClienteDTO(
        Long id,
        String nomeCompleto,
        BigDecimal saldo,
        Role role
) {
}
