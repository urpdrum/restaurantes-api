package com.fiap.restaurantes.domain.usecase.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioPorIdUseCase {
  private final BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface;

  public BuscarUsuarioPorIdUseCase(BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface) {
    this.buscarUsuarioPorIdInterface = buscarUsuarioPorIdInterface;
  }

  public Usuario buscarUsuarioPorId(Long id) {
    Usuario usuario = buscarUsuarioPorIdInterface.buscarUsuarioPorId(id);
    if (usuario == null) {
      throw new UsuarioNotFoundException("Usuário de id: " + id + " não encontrado.");
    }
    return usuario;
  }
}
