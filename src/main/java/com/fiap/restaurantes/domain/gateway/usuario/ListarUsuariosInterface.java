package com.fiap.restaurantes.domain.gateway.usuario;

import com.fiap.restaurantes.domain.entity.Usuario;

import java.util.List;

public interface ListarUsuariosInterface {
  List<Usuario> listarUsuarios();
}
