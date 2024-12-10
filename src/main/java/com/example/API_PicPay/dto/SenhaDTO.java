package com.example.API_PicPay.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SenhaDTO {

    @NotBlank
    @Size(min = 8, max = 10)
    private String senhaAtual;
    @NotBlank
    @Size(min = 8, max = 10)
    private String novaSenha;
    @NotBlank
    @Size(min = 8, max = 10)
    private String repitaSenha;
}
