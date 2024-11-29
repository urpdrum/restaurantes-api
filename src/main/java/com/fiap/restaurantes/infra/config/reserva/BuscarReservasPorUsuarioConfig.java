package com.fiap.restaurantes.infra.config.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservasPorUsuarioInterface;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarReservasPorUsuarioConfig {
    @Bean
    BuscarReservasPorUsuarioUseCase buscarReservasPorUsuarioUseCase(BuscarReservasPorUsuarioInterface buscarReservasPorUsuarioInterface) {
        return new BuscarReservasPorUsuarioUseCase(buscarReservasPorUsuarioInterface);
    }
}
