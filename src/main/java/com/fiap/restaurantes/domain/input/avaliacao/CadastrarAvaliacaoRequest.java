package com.fiap.restaurantes.domain.input.avaliacao;

public record CadastrarAvaliacaoRequest(
        Long restauranteId,
        Long usuarioId,
        Integer nota,
        String comentario
) {
}
