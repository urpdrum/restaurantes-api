package com.fiap.restaurantes.domain.usecase.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.exception.restaurante.RestauranteNotFoundException;
import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorIdInterface;

public class BuscarRestaurantePorIdUseCase {

    private final BuscarRestaurantePorIdInterface buscarRestaurantePorIdInterface;

    public BuscarRestaurantePorIdUseCase(BuscarRestaurantePorIdInterface buscarRestaurantePorIdInterface) {
        this.buscarRestaurantePorIdInterface = buscarRestaurantePorIdInterface;
    }

    public Restaurante buscarRestaurantePorId(Long id) {
        Restaurante restaurante = buscarRestaurantePorIdInterface.buscarRestaurantePorId(id);
        if (restaurante == null) {
            throw new RestauranteNotFoundException("Restaurante de id: " + id + " não encontrado.");
        }
        return restaurante;
    }
}
