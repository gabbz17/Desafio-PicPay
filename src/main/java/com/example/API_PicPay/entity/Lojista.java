package com.example.API_PicPay.entity;

import com.example.API_PicPay.person.Person;
import com.example.API_PicPay.person.Role;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lojista")
public class Lojista extends Person {

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_LOJA;
}
