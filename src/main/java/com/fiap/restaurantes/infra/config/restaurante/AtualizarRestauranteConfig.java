package com.fiap.restaurantes.infra.config.restaurante;


import com.fiap.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import com.fiap.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarRestauranteConfig {

  /**
   * @param atualizarRestauranteInterface
   * @param consultarEnderecoPorCepInterface
   * @return
   */
  @Bean
  public AtualizarRestauranteUseCase atualizarRestauranteUseCase(AtualizarRestauranteInterface atualizarRestauranteInterface,
                                                                 ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface,
                                                                 BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
    return new AtualizarRestauranteUseCase(atualizarRestauranteInterface, consultarEnderecoPorCepInterface, buscarRestaurantePorIdUseCase);
  }
}
