package com.fiap.restaurantes.domain.gateway.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;

import java.util.List;

public interface BuscarAvaliacoesPorRestauranteInterface {

    List<Avaliacao> buscarAvaliacoesPorRestaurante(Long restauranteId);
}
