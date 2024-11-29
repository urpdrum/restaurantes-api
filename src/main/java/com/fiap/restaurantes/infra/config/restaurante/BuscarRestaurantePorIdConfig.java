package com.fiap.restaurantes.infra.config.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorIdInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorIdConfig {

    @Bean
    BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase(BuscarRestaurantePorIdInterface buscarRestaurantePorIdInterface) {
        return new BuscarRestaurantePorIdUseCase(buscarRestaurantePorIdInterface);
    }
}
