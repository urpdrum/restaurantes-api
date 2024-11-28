package com.fiap.restaurantes.domain.mapper.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;

//@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    //UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

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