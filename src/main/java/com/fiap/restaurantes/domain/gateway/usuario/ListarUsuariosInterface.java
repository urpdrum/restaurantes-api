package com.fiap.restaurantes.domain.gateway.usuario;



import com.fiap.restaurantes.domain.entity.validation.Usuario;

import java.util.List;

public interface ListarUsuariosInterface {
  List<Usuario> listarUsuarios();
}
