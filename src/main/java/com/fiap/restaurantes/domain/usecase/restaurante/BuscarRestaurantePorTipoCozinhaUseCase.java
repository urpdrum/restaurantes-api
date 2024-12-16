package com.fiap.restaurantes.domain.usecase.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorTipoCozinhaInterface;

import java.util.List;

public class BuscarRestaurantePorTipoCozinhaUseCase {
  private final BuscarRestaurantePorTipoCozinhaInterface buscarRestaurantePorTipoCozinhaInterface;

  public BuscarRestaurantePorTipoCozinhaUseCase(BuscarRestaurantePorTipoCozinhaInterface buscarRestaurantePorTipoCozinhaInterface) {
    this.buscarRestaurantePorTipoCozinhaInterface = buscarRestaurantePorTipoCozinhaInterface;
  }

  public List<Restaurante> buscarPorTipoCozinha(String tipoCozinha) {
    return buscarRestaurantePorTipoCozinhaInterface.buscarPorTipoCozinha(tipoCozinha);
  }
}
