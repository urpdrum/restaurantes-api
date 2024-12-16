package com.fiap.restaurantes.domain.gateway.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;

import java.util.List;

public interface BuscarReservasPorUsuarioInterface {

    List<Reserva> buscarReservasPorUsuario(Long usuarioId);
}
