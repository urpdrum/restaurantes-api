package com.fiap.restaurantes.infra.config.usuario;

import com.fiap.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;
import com.fiap.restaurantes.domain.usecase.usuario.CadastrarUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarUsuarioConfig {

  @Bean
  public CadastrarUsuarioUseCase cadastrarUsuarioUseCase(CadastrarUsuarioInterface cadastrarUsuarioInterface) {
    return new CadastrarUsuarioUseCase(cadastrarUsuarioInterface);
  }
}
