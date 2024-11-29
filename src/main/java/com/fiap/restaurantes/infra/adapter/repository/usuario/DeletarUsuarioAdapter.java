package com.fiap.restaurantes.infra.adapter.repository.usuario;

import com.fiap.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import com.fiap.restaurantes.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarUsuarioAdapter implements DeletarUsuarioInterface {
  private final UsuarioRepository usuarioRepository;

  @Override
  public boolean deletarUsuario(Long id) {
    usuarioRepository.deleteById(id);
    return true;
  }
}
