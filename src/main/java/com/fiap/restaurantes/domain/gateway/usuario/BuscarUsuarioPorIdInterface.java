package com.fiap.restaurantes.domain.gateway.usuario;

import com.fiap.restaurantes.domain.entity.Usuario;

public interface BuscarUsuarioPorIdInterface {
  Usuario buscarUsuarioPorId(Long id);
}
