package com.fiap.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.gateway.restaurante.ListarRestauranteInterface;
import com.fiap.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarRestauranteAdapter implements ListarRestauranteInterface {
  private final RestauranteRepository repository;
  private final RestauranteEntityMapper entityMapper;


  public ListarRestauranteAdapter(RestauranteRepository repository, RestauranteEntityMapper entityMapper) {
    this.repository = repository;
    this.entityMapper = entityMapper;
  }

  @Override
  public List<Restaurante> listarRestaurantes() {
    List<RestauranteEntity> restaurantesEntity = repository.findAll();

    return restaurantesEntity.stream().map(entityMapper::toRestaurante).toList();
  }
}
