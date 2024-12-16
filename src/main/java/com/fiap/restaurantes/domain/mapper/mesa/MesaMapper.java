package com.fiap.restaurantes.domain.mapper.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.input.mesa.AtualizarMesaRequest;
import com.fiap.restaurantes.domain.input.mesa.CadastrarMesaRequest;
import com.fiap.restaurantes.domain.output.mesa.MesaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MesaMapper {
  MesaMapper INSTANCE = Mappers.getMapper(MesaMapper.class);

  @Mapping(target = "mesaId", ignore = true)
  @Mapping(target = "restaurante.restauranteId", source = "restauranteId")
  Mesa toMesa(CadastrarMesaRequest cadastrarMesaRequest);

  @Mapping(target = "mesaId", ignore = true)
  Mesa toMesa(AtualizarMesaRequest atualizarMesaRequest);

  @Mapping(source = "mesaId", target = "id")
  @Mapping(source = "quantidadeAssentos", target = "capacidade")
  @Mapping(target = "restauranteId", source = "restaurante.restauranteId")
  MesaResponse toMesaResponse(Mesa mesa);
}