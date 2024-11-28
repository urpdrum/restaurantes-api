package com.fiap.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;

public class BuscarUsuarioPorIdUseCase {
  private final BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface;

  public BuscarUsuarioPorIdUseCase(BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface) {
    this.buscarUsuarioPorIdInterface = buscarUsuarioPorIdInterface;
  }

  public Usuario buscarUsuarioPorId(Long id) {
    Usuario usuario = buscarUsuarioPorIdInterface.buscarUsuarioPorId(id);
    if (usuario == null) {
      throw new UsuarioNotFoundException("Usuário de id: " + id + " não encontrado.");
    }
    return usuario;
  }
}
