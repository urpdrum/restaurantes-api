package com.fiap.restaurantes.domain.usecase.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.exception.reserva.ReservaNotFoundException;
import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservaPorIdInterface;

public class BuscarReservaPorIdUseCase {

    private final BuscarReservaPorIdInterface buscarReservaPorIdInterface;

    public BuscarReservaPorIdUseCase(BuscarReservaPorIdInterface buscarReservaPorIdInterface) {
        this.buscarReservaPorIdInterface = buscarReservaPorIdInterface;
    }

    public Reserva buscarReservaPorId(Long id) {
        Reserva reserva = buscarReservaPorIdInterface.buscarReservaPorId(id);
        if(reserva == null) {
            throw new ReservaNotFoundException("Reserva de id: " + id + " não encontrada.");
        }
        return reserva;
    }
}
