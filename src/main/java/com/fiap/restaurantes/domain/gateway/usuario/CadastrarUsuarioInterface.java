package com.fiap.restaurantes.domain.gateway.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;

public interface CadastrarUsuarioInterface {
  Usuario cadastrarUsuario(Usuario usuario);
}
