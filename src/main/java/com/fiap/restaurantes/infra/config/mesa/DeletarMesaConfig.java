package com.fiap.restaurantes.infra.config.mesa;

import com.fiap.restaurantes.domain.gateway.mesa.DeletarMesaInterface;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import com.fiap.restaurantes.domain.usecase.mesa.DeletarMesaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarMesaConfig {
    @Bean
    public DeletarMesaUseCase deletarMesaUseCase(DeletarMesaInterface deletarMesaInterface, BuscarMesaPorIdUseCase buscarMesaPorIdUseCase) {
        return new DeletarMesaUseCase(deletarMesaInterface, buscarMesaPorIdUseCase);
    }
}