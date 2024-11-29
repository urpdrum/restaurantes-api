package com.fiap.restaurantes.domain.input.mesa;

public record CadastrarMesaRequest(
    Long restauranteId,
    Integer quantidadeAssentos
) {
}
