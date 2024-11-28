package com.fiap.restaurantes.domain.gateway.usuario;

import com.fiap.restaurantes.domain.entity.Usuario;

public interface AtualizarUsuarioInterface {
  Usuario atualizarUsuario(Long id, Usuario usuario);
}
