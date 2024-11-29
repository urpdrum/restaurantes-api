package com.fiap.restaurantes.infra.config.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.BuscarAvaliacaoPorIdInterface;
import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarAvaliacaoPorIdConfig {

    @Bean
    BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase(BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface) {
        return new BuscarAvaliacaoPorIdUseCase(buscarAvaliacaoPorIdInterface);
    }
}
