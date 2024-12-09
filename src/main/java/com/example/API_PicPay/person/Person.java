package com.example.API_PicPay.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(of = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Size(min = 11, max = 14)
    @Column(unique = true)
    private String cpfOuCnpj;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(min = 8, max = 10)
    private String senha;
    private BigDecimal saldo;
}
