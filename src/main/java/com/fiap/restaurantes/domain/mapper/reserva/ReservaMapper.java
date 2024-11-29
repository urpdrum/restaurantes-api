package com.fiap.restaurantes.domain.mapper.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.input.reserva.AtualizarReservaRequest;
import com.fiap.restaurantes.domain.input.reserva.CadastrarReservaRequest;
import com.fiap.restaurantes.domain.output.reserva.ReservaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    @Mapping(target = "reservaId", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "mesa", ignore = true)
    Reserva toReserva(CadastrarReservaRequest request);

    @Mapping(target = "reservaId", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "mesa", ignore = true)
    Reserva toReserva(AtualizarReservaRequest request);

    @Mapping(target = "usuarioId", source = "usuario.usuarioId")
    @Mapping(target = "mesaId", source = "mesa.mesaId")
    ReservaResponse toReservaResponse(Reserva reserva);

}
