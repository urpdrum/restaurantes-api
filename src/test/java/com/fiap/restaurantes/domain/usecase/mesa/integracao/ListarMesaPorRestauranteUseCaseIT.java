package com.fiap.restaurantes.domain.usecase.mesa.integracao;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.usecase.mesa.ListarMesasPorRestauranteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ListarMesaPorRestauranteUseCaseIT {
  @Autowired
  private ListarMesasPorRestauranteUseCase listarMesasPorRestauranteUseCase;

  @Test
  void devePermitirListarMesasPorRestaurante() {
    // Arrange
    Long restauranteId = 1L;

    // Act
    List<Mesa> listaMesas = listarMesasPorRestauranteUseCase.listarMesasPorRestaurante(restauranteId);

    // Assert
    assertThat(listaMesas)
        .isNotNull()
        .isNotEmpty()
        .hasSizeGreaterThan(3);
  }

  @Test
  void devePermitirListarMesasPorRestaurante_RestauranteIdNaoExiste() {
    Long restauranteId = 100L;

    List<Mesa> listaMesas = listarMesasPorRestauranteUseCase.listarMesasPorRestaurante(restauranteId);

    assertThat(listaMesas)
        .isEmpty();
  }
}
