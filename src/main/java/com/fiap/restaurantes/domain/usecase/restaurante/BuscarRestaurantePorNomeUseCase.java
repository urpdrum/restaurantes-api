package com.fiap.restaurantes.domain.usecase.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorNomeInterface;

import java.util.List;

public class BuscarRestaurantePorNomeUseCase {
  private final BuscarRestaurantePorNomeInterface buscarRestaurantePorNomeInterface;

  public BuscarRestaurantePorNomeUseCase(BuscarRestaurantePorNomeInterface buscarRestaurantePorNomeInterface) {
    this.buscarRestaurantePorNomeInterface = buscarRestaurantePorNomeInterface;
  }

  public List<Restaurante> buscarRestaurantePorNome(String nome) {
    return buscarRestaurantePorNomeInterface.buscarRestaurantePorNome(nome);
  }
}
