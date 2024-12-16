package com.fiap.restaurantes.infra.config.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;
import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import com.fiap.restaurantes.domain.usecase.avaliacao.DeletarAvaliacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarAvaliacaoConfig {

    @Bean
    DeletarAvaliacaoUseCase deletarAvaliacaoUseCase(DeletarAvaliacaoInterface deletarAvaliacaoInterface,
                                                    BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {
        return new DeletarAvaliacaoUseCase(deletarAvaliacaoInterface, buscarAvaliacaoPorIdUseCase);
    }
}
