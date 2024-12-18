package com.fiap.restaurantes.infra.config.mesa;

import com.fiap.restaurantes.domain.gateway.mesa.AtualizarMesaInterface;
import com.fiap.restaurantes.domain.usecase.mesa.AtualizarMesaUseCase;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarMesaConfig {
    @Bean
    public AtualizarMesaUseCase atualizarMesaUseCase(AtualizarMesaInterface atualizarMesaInterface, BuscarMesaPorIdUseCase buscarMesaPorIdUseCase) {
        return new AtualizarMesaUseCase(atualizarMesaInterface, buscarMesaPorIdUseCase);
    }
}