package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Sistema de Alertas Tempranas ECAES")
                        .version("1.0.0")
                        .description("API REST para el sistema de alertas tempranas académicas de la UPTC")
                        .contact(new Contact()
                                .name("UPTC")
                                .email("soporte@uptc.edu.co")));
    }
}
