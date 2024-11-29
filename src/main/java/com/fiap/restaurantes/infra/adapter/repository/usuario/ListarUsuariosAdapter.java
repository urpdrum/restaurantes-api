package com.fiap.restaurantes.infra.adapter.repository.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.ListarUsuariosInterface;
import com.fiap.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarUsuariosAdapter implements ListarUsuariosInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;

  @Override
  public List<Usuario> listarUsuarios() {
    return usuarioRepository.findAll().stream().map(usuarioEntityMapper::toUsuario).toList();
  }
}
