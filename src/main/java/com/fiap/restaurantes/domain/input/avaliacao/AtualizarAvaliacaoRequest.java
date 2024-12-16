package com.fiap.restaurantes.domain.input.avaliacao;

public record AtualizarAvaliacaoRequest(
        Integer nota,
        String comentario
) {
}
