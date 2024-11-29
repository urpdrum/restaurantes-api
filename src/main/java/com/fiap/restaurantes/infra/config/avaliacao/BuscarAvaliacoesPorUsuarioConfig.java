package com.fiap.restaurantes.infra.config.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;
import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarAvaliacoesPorUsuarioConfig {

    @Bean
    BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase(BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface) {
        return new BuscarAvaliacoesPorUsuarioUseCase(buscarAvaliacoesPorUsuarioInterface);
    }
}
