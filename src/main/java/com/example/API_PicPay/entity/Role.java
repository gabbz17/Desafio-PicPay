package com.example.API_PicPay.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {

    ROLE_PESSOA,
    ROLE_LOJA;

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
