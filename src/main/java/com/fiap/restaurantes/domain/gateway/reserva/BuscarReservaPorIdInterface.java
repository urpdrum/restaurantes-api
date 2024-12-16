package com.fiap.restaurantes.domain.gateway.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;

public interface BuscarReservaPorIdInterface {

    Reserva buscarReservaPorId(Long reservaId);
}
