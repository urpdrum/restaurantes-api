package com.fiap.restaurantes.infra.config.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.ListarRestauranteInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.ListarRestauranteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarRestauranteConfig {

  /**
   * @param outputPort
   * @return
   */
  @Bean
  public ListarRestauranteUseCase listarRestauranteUseCase(ListarRestauranteInterface outputPort) {
    return new ListarRestauranteUseCase(outputPort);
  }
}
