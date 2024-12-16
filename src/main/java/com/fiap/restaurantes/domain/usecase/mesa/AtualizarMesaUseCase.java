package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.AtualizarMesaInterface;

public class AtualizarMesaUseCase {

    private final AtualizarMesaInterface atualizarMesaInterface;
    private final BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;

    public AtualizarMesaUseCase(AtualizarMesaInterface atualizarMesaInterface, BuscarMesaPorIdUseCase buscarMesaPorIdUseCase) {
        this.atualizarMesaInterface = atualizarMesaInterface;
        this.buscarMesaPorIdUseCase = buscarMesaPorIdUseCase;
    }

    public Mesa atualizarMesa(Long mesaId, Mesa mesaNova) {

        Mesa mesa = buscarMesaPorIdUseCase.buscarMesaPorId(mesaId);

        mesa.setQuantidadeAssentos(mesaNova.getQuantidadeAssentos());

        return atualizarMesaInterface.atualizarMesa(mesa);
    }

}