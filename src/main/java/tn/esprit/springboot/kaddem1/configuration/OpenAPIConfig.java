package tn.esprit.springboot.kaddem1.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;


@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    private Info infoAPI() {
        return new Info().title("Kaddem Project")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe les 4 Mousquetaires")
                        .email("*************@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");

        return contact;
    }

    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Product Management API")
                                .pathsToMatch("/product/**")
                                .pathsToExclude("**")
                                .build();
    }
}
