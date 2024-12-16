package com.fiap.restaurantes.infra.config.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.CadastrarReservaInterface;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaEPeriodoUseCase;
import com.fiap.restaurantes.domain.usecase.reserva.CadastrarReservaUseCase;
import com.fiap.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarReservaConfig {
    @Bean
    CadastrarReservaUseCase cadastrarReservaUseCase(CadastrarReservaInterface cadastrarReservaInterface,
                                                    BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
                                                    BuscarMesaPorIdUseCase buscarMesaPorIdUseCase,
                                                    BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase) {
        return new CadastrarReservaUseCase(cadastrarReservaInterface, buscarUsuarioPorIdUseCase, buscarMesaPorIdUseCase, buscarReservasPorMesaEPeriodoUseCase);
    }
}
