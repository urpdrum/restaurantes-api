package com.fiap.restaurantes.domain.usecase.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservasPorUsuarioInterface;

import java.util.List;

public class BuscarReservasPorUsuarioUseCase {

    private final BuscarReservasPorUsuarioInterface buscarReservasPorUsuarioInterface;

    public BuscarReservasPorUsuarioUseCase(BuscarReservasPorUsuarioInterface buscarReservasPorUsuarioInterface) {
        this.buscarReservasPorUsuarioInterface = buscarReservasPorUsuarioInterface;
    }

    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        return buscarReservasPorUsuarioInterface.buscarReservasPorUsuario(usuarioId);
    }
}
