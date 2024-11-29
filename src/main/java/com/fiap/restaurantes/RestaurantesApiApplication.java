package com.fiap.restaurantes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(
        title = "Restaurantes - Grupo 23",
        version = "1.0.0",
        description = "Sistema de gerenciamento de Restaurantes e Reservas desenvolvido para o Tech Challenge da terceira fase da Pós Tech da FIAP. O objetivo do sistema é permitir que os usuários se cadastrem, realizem agendamento de reservas e possam registrar comentários e avaliações sobre os restaurantes."
))
public class RestaurantesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantesApiApplication.class, args);
    }

}
