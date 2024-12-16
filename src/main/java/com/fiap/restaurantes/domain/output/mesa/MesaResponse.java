package com.fiap.restaurantes.domain.output.mesa;

public record MesaResponse(Long id,
                           Long restauranteId,
                           int capacidade ) {

}
