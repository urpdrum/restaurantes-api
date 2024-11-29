package com.fiap.restaurantes.infra.adapter.repository.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;
import com.fiap.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import org.springframework.stereotype.Component;


@Component
public class BuscarUsuarioPorIdAdapter implements BuscarUsuarioPorIdInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;

  public BuscarUsuarioPorIdAdapter(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
    this.usuarioRepository = usuarioRepository;
    this.usuarioEntityMapper = usuarioEntityMapper;
  }

  @Override
  public Usuario buscarUsuarioPorId(Long id) {
    UsuarioEntity usuarioBuscado = usuarioRepository
        .findById(id)
        .orElse(null);

    return usuarioEntityMapper.toUsuario(usuarioBuscado);
  }
}
