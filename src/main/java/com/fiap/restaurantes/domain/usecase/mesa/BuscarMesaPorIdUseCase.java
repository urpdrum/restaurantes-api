package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;

public class BuscarMesaPorIdUseCase {

    private final BuscarMesaPorIdInterface buscarMesaPorIdInterface;

    public BuscarMesaPorIdUseCase(BuscarMesaPorIdInterface buscarMesaPorIdInterface) {
        this.buscarMesaPorIdInterface = buscarMesaPorIdInterface;
    }

    public Mesa buscarMesaPorId(Long mesaId) {
        Mesa mesa = buscarMesaPorIdInterface.buscarMesaPorId(mesaId);

        if(mesa == null) {
            throw new MesaNotFoundException("Mesa de id: " + mesaId + " não encontrada");
        }

        return mesa;
    }
}