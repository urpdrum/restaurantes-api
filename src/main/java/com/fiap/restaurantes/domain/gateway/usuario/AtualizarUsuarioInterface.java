package com.fiap.restaurantes.domain.gateway.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;

public interface AtualizarUsuarioInterface {
  Usuario atualizarUsuario(Long id, Usuario usuario);
}
