package com.example.API_PicPay.dto;

import com.example.API_PicPay.person.Role;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record PessoaDTO(
        Long id,
        String nomeCompleto,
        BigDecimal saldo,
        Role role
) {
}
