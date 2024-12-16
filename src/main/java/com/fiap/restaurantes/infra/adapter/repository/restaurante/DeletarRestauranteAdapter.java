package com.fiap.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;
import com.fiap.restaurantes.infra.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletarRestauranteAdapter implements DeletarRestauranteInterface {
  private final RestauranteRepository restauranteRepository;

  public DeletarRestauranteAdapter(RestauranteRepository restauranteRepository) {
    this.restauranteRepository = restauranteRepository;
  }

  @Override
  public boolean deletarRestaurante(Long id) {
    restauranteRepository.deleteById(id);
    return true;
  }
}
