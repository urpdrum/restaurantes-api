package com.fiap.restaurantes.infra.repository.mapper;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.infra.entity.MesaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MesaEntityMapper {

    MesaEntityMapper INSTANCE = Mappers.getMapper(MesaEntityMapper.class);

    /**
     * @param mesa
     * @return
     */
    @Mapping(target = "restauranteEntity.restauranteId", source = "restaurante.restauranteId")
    @Mapping(target = "restauranteEntity.mesas", ignore = true)
    MesaEntity toMesaEntity (Mesa mesa);

    /**
     * @param mesaEntity
     * @return
     */
    @Mapping(target = "restaurante.restauranteId", source = "restauranteEntity.restauranteId")
    @Mapping(target = "restaurante.mesas", ignore = true)
    Mesa toMesa(MesaEntity mesaEntity);


}
