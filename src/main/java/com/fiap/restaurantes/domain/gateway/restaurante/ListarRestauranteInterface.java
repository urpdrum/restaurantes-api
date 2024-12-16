package com.fiap.restaurantes.domain.gateway.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;

import java.util.List;

public interface ListarRestauranteInterface {
  List<Restaurante> listarRestaurantes();
}
