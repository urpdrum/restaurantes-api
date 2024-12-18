package com.fiap.restaurantes.domain.usecase.mesa.integracao;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BuscarMesaPorIdUseCaseIT {
  @Autowired
  private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;

  @Test
  void devePermitirBuscarMesaPorId() {
    Long id = 1L;

    Mesa mesa = buscarMesaPorIdUseCase.buscarMesaPorId(id);

    assertThat(mesa)
        .isNotNull()
        .isInstanceOf(Mesa.class);

    assertThat(mesa.getMesaId())
        .isEqualTo(id);
  }

  @Test
  void deveGerarExcecao_QuandoBuscarMesaPorId_IdDaMesaNaoExiste() {
    Long id = 100L;

    assertThatThrownBy(() -> buscarMesaPorIdUseCase.buscarMesaPorId(id))
        .isInstanceOf(MesaNotFoundException.class)
        .hasMessage("Mesa de id: " + id + " não encontrada");
  }
}
