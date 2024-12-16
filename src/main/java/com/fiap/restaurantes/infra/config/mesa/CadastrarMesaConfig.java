package com.fiap.restaurantes.infra.config.mesa;

import com.fiap.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.restaurantes.domain.usecase.mesa.CadastrarMesaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarMesaConfig {

  @Bean
  public CadastrarMesaUseCase cadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    return new CadastrarMesaUseCase(cadastrarMesaInterface);
  }
}