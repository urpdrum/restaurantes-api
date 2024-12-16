package com.fiap.restaurantes.infra.config.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorLocalidadeInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorLocalidadeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorLocalidadeConfig {

  @Bean
  public BuscarRestaurantePorLocalidadeUseCase buscarRestaurantesPorLocalidadeUseCase(
          BuscarRestaurantePorLocalidadeInterface buscarRestaurantePorLocalidadeInterface
  ) {
    return new BuscarRestaurantePorLocalidadeUseCase(buscarRestaurantePorLocalidadeInterface);
  }
}
