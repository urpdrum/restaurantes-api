package com.fiap.restaurantes.domain.gateway.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;

public interface BuscarMesaPorIdInterface {
    Mesa buscarMesaPorId(Long mesaId);
}