package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.ListarMesasPorRestauranteInterface;

import java.util.List;

public class ListarMesasPorRestauranteUseCase {

    private final ListarMesasPorRestauranteInterface listarMesasPorRestauranteInterface;

    public ListarMesasPorRestauranteUseCase(ListarMesasPorRestauranteInterface listarMesasPorRestauranteInterface) {
        this.listarMesasPorRestauranteInterface = listarMesasPorRestauranteInterface;
    }

    public List<Mesa> listarMesasPorRestaurante(Long restauranteId) {
        return listarMesasPorRestauranteInterface.listarMesasPorRestaurante(restauranteId);
    }
}