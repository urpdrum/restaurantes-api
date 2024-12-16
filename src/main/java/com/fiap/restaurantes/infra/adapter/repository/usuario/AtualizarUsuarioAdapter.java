package com.fiap.restaurantes.infra.adapter.repository.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;
import com.fiap.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarUsuarioAdapter implements AtualizarUsuarioInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;
  private final BuscarUsuarioPorIdAdapter buscarUsuarioPorIdAdapter;

  @Override
  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    UsuarioEntity usuarioAtualizado = usuarioRepository.save(usuarioEntityMapper.toUsuarioEntity(usuario));

    return usuarioEntityMapper.toUsuario(usuarioAtualizado);
  }
}
