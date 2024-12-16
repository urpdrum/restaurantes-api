package com.fiap.restaurantes.domain.gateway.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarReservasPorMesaEPeriodoInterface {

    List<Reserva> buscarReservasPorMesaEPeriodo(Long mesaId, LocalDateTime dataInicio, LocalDateTime dataFim);
}
