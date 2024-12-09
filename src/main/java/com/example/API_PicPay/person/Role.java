package com.example.API_PicPay.person;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {

    ROLE_LOJA,
    ROLE_PESSOA;

    @JsonCreator
    public static Role fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "PESSOA":
                    return ROLE_PESSOA;
                case "LOJA":
                    return ROLE_LOJA;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Role: " + value);
    }
}
