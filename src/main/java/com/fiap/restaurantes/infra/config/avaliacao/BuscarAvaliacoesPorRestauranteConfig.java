package com.fiap.restaurantes.infra.config.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorRestauranteInterface;
import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorRestauranteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarAvaliacoesPorRestauranteConfig {

    @Bean
    BuscarAvaliacoesPorRestauranteUseCase buscarAvaliacoesPorRestauranteUseCase(BuscarAvaliacoesPorRestauranteInterface buscarAvaliacoesPorRestauranteInterface) {
        return new BuscarAvaliacoesPorRestauranteUseCase(buscarAvaliacoesPorRestauranteInterface);
    }
}
