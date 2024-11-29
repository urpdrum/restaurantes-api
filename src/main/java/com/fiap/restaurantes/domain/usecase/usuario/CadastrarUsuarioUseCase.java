package com.fiap.restaurantes.domain.usecase.usuario;

import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;

public class CadastrarUsuarioUseCase {
  private final CadastrarUsuarioInterface cadastrarUsuarioInterface;

    public CadastrarUsuarioUseCase(CadastrarUsuarioInterface cadastrarUsuarioInterface) {
        this.cadastrarUsuarioInterface = cadastrarUsuarioInterface;
    }
    public Usuario cadastrarUsuario (Usuario usuario) {
        return cadastrarUsuarioInterface.cadastrarUsuario(usuario);
    }
}

