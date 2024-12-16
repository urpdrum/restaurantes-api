package com.fiap.restaurantes.domain.usecase.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.restaurantes.domain.gateway.avaliacao.BuscarAvaliacaoPorIdInterface;

public class BuscarAvaliacaoPorIdUseCase {

    private final BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface;

    public BuscarAvaliacaoPorIdUseCase(BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface) {
        this.buscarAvaliacaoPorIdInterface = buscarAvaliacaoPorIdInterface;
    }

    public Avaliacao buscarAvaliacaoPorId(Long id) {

        Avaliacao avaliacao = buscarAvaliacaoPorIdInterface.buscarAvaliacaoPorId(id);
        if (avaliacao == null) {
            throw new AvaliacaoNotFoundException("Avaliação de id: " + id + " não encontrada.");
        }

        return avaliacao;
    }
}
