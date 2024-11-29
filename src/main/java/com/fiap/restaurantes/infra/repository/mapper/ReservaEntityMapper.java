package com.fiap.restaurantes.infra.repository.mapper;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.infra.entity.ReservaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservaEntityMapper {

    ReservaEntityMapper INSTANCE = Mappers.getMapper(ReservaEntityMapper.class);

    @Mapping(target = "usuario.usuarioId", source = "usuarioEntity.usuarioId")
    @Mapping(target = "mesa.mesaId", source = "mesaEntity.mesaId")
    Reserva toReserva(ReservaEntity reservaEntity);

    @Mapping(target = "usuarioEntity.usuarioId", source = "usuario.usuarioId")
    @Mapping(target = "mesaEntity.mesaId", source = "mesa.mesaId")
    ReservaEntity toReservaEntity(Reserva reserva);
}
