package com.fiap.restaurantes.infra.config.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.AtualizarAvaliacaoInterface;
import com.fiap.restaurantes.domain.usecase.avaliacao.AtualizarAvaliacaoUseCase;
import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarAvaliacaoConfig {

    @Bean
    AtualizarAvaliacaoUseCase atualizarAvaliacaoUseCase(AtualizarAvaliacaoInterface atualizarAvaliacaoInterface,
                                                        BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {

        return new AtualizarAvaliacaoUseCase(atualizarAvaliacaoInterface, buscarAvaliacaoPorIdUseCase);
    }
}
