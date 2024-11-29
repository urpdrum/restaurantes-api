package com.fiap.restaurantes.domain.gateway.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;

public interface BuscarRestaurantePorIdInterface {

    Restaurante buscarRestaurantePorId(Long id);
}
