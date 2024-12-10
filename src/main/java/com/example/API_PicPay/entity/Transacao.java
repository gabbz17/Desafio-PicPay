package com.example.API_PicPay.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transferencia")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String remetente;
    @NotBlank
    @Size(min = 8, max = 10)
    private String senhaRemetente;
    @NotBlank
    private String destinatario;
    @NotNull
    private BigDecimal valor;
    LocalDateTime horaTransacao = LocalDateTime.now();

}
