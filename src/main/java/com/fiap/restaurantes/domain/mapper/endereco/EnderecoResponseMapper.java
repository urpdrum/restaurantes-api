package com.fiap.restaurantes.domain.mapper.endereco;

import com.fiap.restaurantes.domain.entity.Endereco;
import com.fiap.restaurantes.domain.output.endereco.EnderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoResponseMapper {

    EnderecoResponseMapper INSTANCE = Mappers.getMapper(EnderecoResponseMapper.class);

    @Mapping(target = "cidade", source = "localidade")
    Endereco toEndereco(EnderecoResponse enderecoResponse);

}
