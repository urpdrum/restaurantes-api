package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.restaurantes.utils.mesa.MesaHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CadastrarMesaUseCaseTest {
  private CadastrarMesaUseCase cadastrarMesaUseCase;

  @Mock
  private CadastrarMesaInterface cadastrarMesaInterface;

  AutoCloseable openMocks;

  @BeforeEach
  void setUp() {
    openMocks = MockitoAnnotations.openMocks(this);
    cadastrarMesaUseCase = new CadastrarMesaUseCase(cadastrarMesaInterface);
  }

  @AfterEach
  void tearDown() throws Exception {
    openMocks.close();
  }

  @Test
  void devePermitirCadastrarMesa() {
    // Arrange
    Mesa mesa = MesaHelper.gerarMesa();

    when(cadastrarMesaInterface.cadastrarMesa(any(Mesa.class))).thenAnswer(answer -> answer.getArgument(0));

    // Act
    Mesa mesaCadastrada = cadastrarMesaUseCase.cadastrarMesa(mesa);

    // Assert
    assertThat(mesaCadastrada)
        .isNotNull()
        .isInstanceOf(Mesa.class);

    assertThat(mesaCadastrada.getQuantidadeAssentos())
        .isEqualTo(mesa.getQuantidadeAssentos());

    assertThat(mesaCadastrada.getRestaurante().getRestauranteId())
        .isEqualTo(mesa.getRestaurante().getRestauranteId());

    verify(cadastrarMesaInterface, times(1)).cadastrarMesa(any(Mesa.class));
  }
}
