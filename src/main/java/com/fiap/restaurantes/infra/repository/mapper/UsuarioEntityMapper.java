package com.fiap.restaurantes.infra.repository.mapper;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
  UsuarioEntityMapper INSTANCE = Mappers.getMapper(UsuarioEntityMapper.class);

  /**
   * @param usuario
   * @return
   */
  UsuarioEntity toUsuarioEntity(Usuario usuario);

  /**
   * @param usuarioEntity
   * @return
   */
  Usuario toUsuario(UsuarioEntity usuarioEntity);
}
