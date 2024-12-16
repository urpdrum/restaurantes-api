package com.fiap.restaurantes.infra.adapter.repository.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;
import com.fiap.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarUsuarioAdapter implements CadastrarUsuarioInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;


  @Override
  public Usuario cadastrarUsuario(Usuario usuario) {
    UsuarioEntity usuarioEntity = usuarioEntityMapper.toUsuarioEntity(usuario);
    usuarioRepository.save(usuarioEntity);
    return usuarioEntityMapper.toUsuario(usuarioEntity);
  }
}
