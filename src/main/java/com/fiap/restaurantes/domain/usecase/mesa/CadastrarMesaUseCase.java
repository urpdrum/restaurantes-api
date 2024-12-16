package com.fiap.restaurantes.domain.usecase.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;

public class CadastrarMesaUseCase {

  private final CadastrarMesaInterface cadastrarMesaInterface;

  public CadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    this.cadastrarMesaInterface = cadastrarMesaInterface;
  }

  public Mesa cadastrarMesa(Mesa mesa) {
    return cadastrarMesaInterface.cadastrarMesa(mesa);
  }
}