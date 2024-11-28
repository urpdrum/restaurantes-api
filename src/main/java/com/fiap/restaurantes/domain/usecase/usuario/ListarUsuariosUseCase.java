package com.fiap.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.ListarUsuariosInterface;

import java.util.List;

public class ListarUsuariosUseCase {
  private final ListarUsuariosInterface listarUsuariosInterface;

  public ListarUsuariosUseCase(ListarUsuariosInterface listarUsuariosInterface) {
    this.listarUsuariosInterface = listarUsuariosInterface;
  }

  public List<Usuario> listarUsuarios() {
    return listarUsuariosInterface.listarUsuarios();
  }
}
