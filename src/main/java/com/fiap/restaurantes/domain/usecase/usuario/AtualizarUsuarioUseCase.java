package com.fiap.restaurantes.domain.usecase.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;
import org.springframework.stereotype.Service;

@Service
public class AtualizarUsuarioUseCase {
  private final AtualizarUsuarioInterface atualizarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  public AtualizarUsuarioUseCase(AtualizarUsuarioInterface atualizarUsuarioInterface, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase) {
    this.atualizarUsuarioInterface = atualizarUsuarioInterface;
    this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
  }

  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    Usuario usuarioBuscado = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);

    usuarioBuscado.setNome(usuario.getNome());
    usuarioBuscado.setTelefone(usuario.getTelefone());
    usuarioBuscado.setSenha(usuario.getSenha());

    return atualizarUsuarioInterface.atualizarUsuario(id, usuarioBuscado);
  }
}
