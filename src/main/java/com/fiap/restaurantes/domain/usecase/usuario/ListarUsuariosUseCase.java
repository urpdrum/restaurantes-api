package com.fiap.restaurantes.domain.usecase.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.ListarUsuariosInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListarUsuariosUseCase {
  private final ListarUsuariosInterface listarUsuariosInterface;

  public ListarUsuariosUseCase(ListarUsuariosInterface listarUsuariosInterface) {
    this.listarUsuariosInterface = listarUsuariosInterface;
  }

  public List<Usuario> listarUsuarios() {
    return listarUsuariosInterface.listarUsuarios();
  }
}
