package com.fiap.restaurantes.domain.usecase.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.entity.validation.avaliacao.AvaliacaoValidator;
import com.fiap.restaurantes.domain.gateway.avaliacao.AtualizarAvaliacaoInterface;

public class AtualizarAvaliacaoUseCase {

    private final AtualizarAvaliacaoInterface atualizarAvaliacaoInterface;
    private final BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    public AtualizarAvaliacaoUseCase(AtualizarAvaliacaoInterface atualizarAvaliacaoInterface, BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {
        this.atualizarAvaliacaoInterface = atualizarAvaliacaoInterface;
        this.buscarAvaliacaoPorIdUseCase = buscarAvaliacaoPorIdUseCase;
    }

    public Avaliacao atualizarAvaliacao(Long id, Avaliacao avaliacaoNova) {

        Avaliacao avaliacao = buscarAvaliacaoPorIdUseCase.buscarAvaliacaoPorId(id);

        avaliacao.setNota(avaliacaoNova.getNota());
        avaliacao.setComentario(avaliacaoNova.getComentario());

        AvaliacaoValidator.validate(avaliacao);

        return atualizarAvaliacaoInterface.atualizarAvaliacao(avaliacao);

    }
}
