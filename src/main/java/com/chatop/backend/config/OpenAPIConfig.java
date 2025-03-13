package com.chatop.backend.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(title = "ChatOp",
                version = "1.0",
                description = "API de gestion de l'application ChatOp",
                contact = @Contact(
                        name = "Christophe",
                        url = "https://github.com/christopheocr"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Code source du projet sur GitHub",
                url = "https://github.com/christopheocr/chatop-backend"
        )
)
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class OpenAPIConfig {
}
