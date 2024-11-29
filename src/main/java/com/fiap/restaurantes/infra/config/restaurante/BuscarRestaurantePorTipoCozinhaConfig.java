package com.fiap.restaurantes.infra.config.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorTipoCozinhaInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorTipoCozinhaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorTipoCozinhaConfig {

  @Bean
  public BuscarRestaurantePorTipoCozinhaUseCase buscarRestaurantePorTipoCozinhaUseCase(
      BuscarRestaurantePorTipoCozinhaInterface buscarRestaurantePorTipoCozinhaInterface
  ) {
    return new BuscarRestaurantePorTipoCozinhaUseCase(buscarRestaurantePorTipoCozinhaInterface);
  }
}
