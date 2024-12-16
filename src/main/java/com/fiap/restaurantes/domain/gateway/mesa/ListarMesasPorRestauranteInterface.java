package com.fiap.restaurantes.domain.gateway.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;

import java.util.List;

public interface ListarMesasPorRestauranteInterface {
    List<Mesa> listarMesasPorRestaurante(Long restauranteId);
}