package com.fiap.restaurantes.domain.gateway.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;

import java.util.List;

public interface BuscarReservasPorMesaInterface {

    List<Reserva> buscarReservasPorMesa(Long mesaId);
}
