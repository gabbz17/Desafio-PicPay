package com.example.API_PicPay.entity;

import com.example.API_PicPay.person.Person;
import com.example.API_PicPay.person.Role;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa extends Person {

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_PESSOA;
}
