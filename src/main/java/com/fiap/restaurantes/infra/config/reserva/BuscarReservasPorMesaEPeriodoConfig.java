package com.fiap.restaurantes.infra.config.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaEPeriodoInterface;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaEPeriodoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarReservasPorMesaEPeriodoConfig {
    @Bean
    BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase(BuscarReservasPorMesaEPeriodoInterface buscarReservasPorMesaEPeriodoInterface) {
        return new BuscarReservasPorMesaEPeriodoUseCase(buscarReservasPorMesaEPeriodoInterface);
    }
}
