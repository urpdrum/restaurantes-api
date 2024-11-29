package com.fiap.restaurantes.infra.config.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.AtualizarReservaInterface;
import com.fiap.restaurantes.domain.usecase.reserva.AtualizarReservaUseCase;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservaPorIdUseCase;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaEPeriodoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarReservaConfig {
    @Bean
    AtualizarReservaUseCase atualizarReservaUseCase(BuscarReservaPorIdUseCase buscarReservaPorIdUseCase,
                                                    AtualizarReservaInterface atualizarReservaInterface,
                                                    BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase) {
        return new AtualizarReservaUseCase(buscarReservaPorIdUseCase, atualizarReservaInterface, buscarReservasPorMesaEPeriodoUseCase);
    }
}
