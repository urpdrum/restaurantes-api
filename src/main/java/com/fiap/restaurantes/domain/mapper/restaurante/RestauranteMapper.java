package com.fiap.restaurantes.domain.mapper.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.input.restaurante.AtualizarRestauranteRequest;
import com.fiap.restaurantes.domain.input.restaurante.CadastrarRestauranteRequest;
import com.fiap.restaurantes.domain.output.restaurante.RestauranteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    /**
     * @param restauranteRequest
     * @return
     */
    @Mapping(target = "restauranteId", ignore = true)
    Restaurante toRestaurante(CadastrarRestauranteRequest restauranteRequest);

    @Mapping(target = "restauranteId", ignore = true)
    Restaurante toRestaurante(AtualizarRestauranteRequest restauranteRequest);

    /**
     * @param restaurante
     * @return
     */
    RestauranteResponse toRestauranteResponse(Restaurante restaurante);

}
