package com.fiap.restaurantes.domain.mapper.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    //UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    /**
     * @param cadastrarUsuarioRequest
     * @return
     */
    @Mapping(target = "usuarioId", ignore = true)
    Usuario toUsuario(CadastrarUsuarioRequest cadastrarUsuarioRequest);

    /**
     * @param atualizarUsuarioRequest
     * @return
     */
    @Mapping(target = "usuarioId", ignore = true)
    Usuario toUsuario(AtualizarUsuarioRequest atualizarUsuarioRequest);
    /**
     * @param usuario
     * @return
     */
    UsuarioResponse toUsuarioResponse(Usuario usuario);
}