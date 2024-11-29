package com.fiap.restaurantes.infra.config.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorNomeInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorNomeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorNomeConfig {

  @Bean
  public BuscarRestaurantePorNomeUseCase buscarRestaurantesPorNomeUseCase(
      BuscarRestaurantePorNomeInterface buscarRestaurantePorNomeInterface
  ) {
    return new BuscarRestaurantePorNomeUseCase(buscarRestaurantePorNomeInterface);
  }
}
