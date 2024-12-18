package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.gateway.mesa.DeletarMesaInterface;

public class DeletarMesaUseCase {

    private final BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
    private final DeletarMesaInterface deletarMesaInterface;

    public DeletarMesaUseCase(
            DeletarMesaInterface deletarMesaInterface,
            BuscarMesaPorIdUseCase buscarMesaPorIdUseCase
    ) {
        this.deletarMesaInterface = deletarMesaInterface;
        this.buscarMesaPorIdUseCase = buscarMesaPorIdUseCase;
    }

    public boolean deletarMesa(Long mesaId) {
        buscarMesaPorIdUseCase.buscarMesaPorId(mesaId);
        return deletarMesaInterface.deletarMesa(mesaId);
    }
}