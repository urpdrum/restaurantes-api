package com.fiap.restaurantes.infra.config.mesa;

import com.fiap.restaurantes.domain.gateway.mesa.ListarMesasPorRestauranteInterface;
import com.fiap.restaurantes.domain.usecase.mesa.ListarMesasPorRestauranteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarMesasConfig {
    @Bean
    public ListarMesasPorRestauranteUseCase listarMesasUseCase(ListarMesasPorRestauranteInterface listarMesasPorRestauranteInterface) {
        return new ListarMesasPorRestauranteUseCase(listarMesasPorRestauranteInterface);
    }
}