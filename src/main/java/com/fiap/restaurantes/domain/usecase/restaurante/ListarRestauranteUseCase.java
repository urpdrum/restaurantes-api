package com.fiap.restaurantes.domain.usecase.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.gateway.restaurante.ListarRestauranteInterface;

import java.util.List;

public class ListarRestauranteUseCase {
  private final ListarRestauranteInterface listarRestauranteInterface;

  public ListarRestauranteUseCase(ListarRestauranteInterface listarRestauranteInterface) {
    this.listarRestauranteInterface = listarRestauranteInterface;
  }

  public List<Restaurante> listarRestaurantes() {
    return listarRestauranteInterface.listarRestaurantes();
  }
}
