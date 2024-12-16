package com.fiap.restaurantes.domain.usecase.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;

import java.util.List;

public class BuscarAvaliacoesPorUsuarioUseCase {

    private final BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface;

    public BuscarAvaliacoesPorUsuarioUseCase(BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface) {
        this.buscarAvaliacoesPorUsuarioInterface = buscarAvaliacoesPorUsuarioInterface;
    }

    public List<Avaliacao> buscarAvaliacoesPorUsuario(Long usuarioId) {
        return buscarAvaliacoesPorUsuarioInterface.buscarAvaliacoesPorUsuario(usuarioId);
    }
}
