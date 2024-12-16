package com.fiap.restaurantes.domain.usecase.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.entity.validation.restaurante.RestauranteValidator;
import com.fiap.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import com.fiap.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import feign.FeignException;

public class AtualizarRestauranteUseCase {

  private final AtualizarRestauranteInterface atualizarRestauranteInterface;
  private final ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface;
  private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;

  public AtualizarRestauranteUseCase(AtualizarRestauranteInterface atualizarRestauranteInterface, ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface, BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
    this.atualizarRestauranteInterface = atualizarRestauranteInterface;
    this.consultarEnderecoPorCepInterface = consultarEnderecoPorCepInterface;
    this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
  }

  public Restaurante atualizarRestaurante(Long restauranteId, Restaurante restauranteNovo) {

    Restaurante restaurante = buscarRestaurantePorIdUseCase.buscarRestaurantePorId(restauranteId);

    if (!restaurante.getEndereco().getCep().equals(restauranteNovo.getEndereco().getCep())) {

      try {

        var endereco = consultarEnderecoPorCepInterface.consultaPorCep(restauranteNovo.getEndereco().getCep());

        if (endereco.getCep() == null)
          throw new IllegalArgumentException("CEP inexistente.");

        endereco.setComplemento(restauranteNovo.getEndereco().getComplemento());
        endereco.setNumero(restauranteNovo.getEndereco().getNumero());
        restaurante.setEndereco(endereco);

      } catch (FeignException e) {
        throw new IllegalArgumentException("CEP inexistente.");
      }

    }

    restaurante.setNome(restauranteNovo.getNome());
    restaurante.setCapacidade(restauranteNovo.getCapacidade());
    restaurante.setHorarioFuncionamento(restauranteNovo.getHorarioFuncionamento());
    restaurante.setTipoDeCozinha(restauranteNovo.getTipoDeCozinha());

    RestauranteValidator.validateRestaurante(restaurante);

    return atualizarRestauranteInterface.atualizarRestaurante(restaurante);
  }
}
