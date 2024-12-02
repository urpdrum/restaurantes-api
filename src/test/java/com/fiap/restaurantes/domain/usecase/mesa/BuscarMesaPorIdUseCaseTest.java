package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;
import com.fiap.restaurantes.utils.mesa.MesaHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuscarMesaPorIdUseCaseTest {
  private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;

  @Mock
  private BuscarMesaPorIdInterface buscarMesaPorIdInterface;

  AutoCloseable openMocks;

  @BeforeEach
  void setUp() {
    openMocks = MockitoAnnotations.openMocks(this);
    buscarMesaPorIdUseCase = new BuscarMesaPorIdUseCase(buscarMesaPorIdInterface);
  }

  @AfterEach
  void tearDown() throws Exception {
    openMocks.close();
  }

  @Test
  void testBuscarMesaPorIdUseCase() {
    // Arrange
    Long id = 1L;
    Mesa mesa = MesaHelper.gerarMesa();
    mesa.setMesaId(id);

    when(buscarMesaPorIdInterface.buscarMesaPorId(any(Long.class))).thenReturn(mesa);

    // Act
    Mesa mesaBuscada = buscarMesaPorIdUseCase.buscarMesaPorId(id);

    // Assert
    assertThat(mesaBuscada)
        .isNotNull()
        .isInstanceOf(Mesa.class);

    assertThat(mesaBuscada.getMesaId())
        .isEqualTo(id);

    assertThat(mesaBuscada.getQuantidadeAssentos())
        .isEqualTo(mesa.getQuantidadeAssentos());

    assertThat(mesaBuscada.getRestaurante().getRestauranteId())
        .isEqualTo(mesa.getRestaurante().getRestauranteId());
  }

  @Test
  void deveGerarExcecao_QuandoBuscarMesaPorId_IdDaMesaNaoExiste() {
    // Arrange
    Long id = 1L;

    when(buscarMesaPorIdInterface.buscarMesaPorId(any(Long.class))).thenReturn(null);

    // Act && Assert
    assertThatThrownBy(() -> buscarMesaPorIdUseCase.buscarMesaPorId(id))
        .isInstanceOf(MesaNotFoundException.class)
        .hasMessage("Mesa de id: " + id + " não encontrada");

    verify(buscarMesaPorIdInterface, times(1)).buscarMesaPorId(any(Long.class));

  }
}
