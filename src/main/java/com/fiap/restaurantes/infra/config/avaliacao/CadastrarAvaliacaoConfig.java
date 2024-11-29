package com.fiap.restaurantes.infra.config.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.restaurantes.domain.usecase.avaliacao.CadastrarAvaliacaoUseCase;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import com.fiap.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarAvaliacaoConfig {

    @Bean
    CadastrarAvaliacaoUseCase cadastrarAvaliacaoUseCase(CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface,
                                                        BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
                                                        BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
        return new CadastrarAvaliacaoUseCase(cadastrarAvaliacaoInterface, buscarUsuarioPorIdUseCase, buscarRestaurantePorIdUseCase);
    }
}
