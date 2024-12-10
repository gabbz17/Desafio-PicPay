package com.example.API_PicPay.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI OpenAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("API do Desafio PicPay")
                                .description("Desafio proposto da empresa PicPay")
                                .version("v1")
                                .contact(new Contact()
                                        .email("coutinho.dev17@gmail.com")
                                        .name("Gabriel Coutinho")
                                        .url("mailto:coutinho.dev17@gmail.com"))
                );
    }
}
