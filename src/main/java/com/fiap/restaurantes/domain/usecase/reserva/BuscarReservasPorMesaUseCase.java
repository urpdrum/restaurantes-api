package com.fiap.restaurantes.domain.usecase.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaInterface;

import java.util.List;

public class BuscarReservasPorMesaUseCase {

    private final BuscarReservasPorMesaInterface buscarReservasPorMesaInterface;

    public BuscarReservasPorMesaUseCase(BuscarReservasPorMesaInterface buscarReservasPorMesaInterface) {
        this.buscarReservasPorMesaInterface = buscarReservasPorMesaInterface;
    }

    public List<Reserva> buscarReservasPorMesa(Long mesaId) {
        return buscarReservasPorMesaInterface.buscarReservasPorMesa(mesaId);
    }
}
