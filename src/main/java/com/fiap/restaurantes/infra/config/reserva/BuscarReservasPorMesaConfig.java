package com.fiap.restaurantes.infra.config.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaInterface;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarReservasPorMesaConfig {
    @Bean
    BuscarReservasPorMesaUseCase buscarReservasPorMesaUseCase(BuscarReservasPorMesaInterface buscarReservasPorMesaInterface) {
        return new BuscarReservasPorMesaUseCase(buscarReservasPorMesaInterface);
    }
}
