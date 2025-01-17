package com.claujulian.one_forohub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT"))
                )
                .info(new Info()
                        .title("Foro Hub")
                        .description("API Rest con funcionalidades C.R.U.D de Tópicos, Respuestas a Tópicos, Alumnos y Login de Autenticación.")
                        .contact(new Contact()
                                .name("Claudia E.Julian")
                                .email("wg.claudiajulian@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://forhub/api/licencia")));
    }
}
