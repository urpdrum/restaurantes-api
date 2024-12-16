package com.fiap.restaurantes.infra.config.mesa;

import com.fiap.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarMesaPorIdConfig {
    @Bean
    public BuscarMesaPorIdUseCase buscarMesaPorIdUseCase(BuscarMesaPorIdInterface buscarMesaPorIdInterface) {
        return new BuscarMesaPorIdUseCase(buscarMesaPorIdInterface);
    }
}