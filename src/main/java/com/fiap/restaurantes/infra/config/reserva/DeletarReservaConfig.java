package com.fiap.restaurantes.infra.config.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.DeletarReservaInterface;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservaPorIdUseCase;
import com.fiap.restaurantes.domain.usecase.reserva.DeletarReservaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarReservaConfig {
    @Bean
    DeletarReservaUseCase deletarReservaUseCase(DeletarReservaInterface deletarReservaInterface, BuscarReservaPorIdUseCase buscarReservaPorIdUseCase) {
        return new DeletarReservaUseCase(buscarReservaPorIdUseCase, deletarReservaInterface);
    }
}
