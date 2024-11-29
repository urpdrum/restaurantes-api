package com.fiap.restaurantes.domain.gateway.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;

public interface BuscarAvaliacaoPorIdInterface {
    Avaliacao buscarAvaliacaoPorId(Long id);
}
