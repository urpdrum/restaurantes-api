package com.fiap.restaurantes.domain.gateway.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;

import java.util.List;

public interface BuscarAvaliacoesPorUsuarioInterface {

    List<Avaliacao> buscarAvaliacoesPorUsuario(Long usuarioId);
}
