package com.fiap.restaurantes.infra.adapter.repository.mesa;


import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.restaurantes.infra.entity.MesaEntity;
import com.fiap.restaurantes.infra.repository.MesaRepository;
import com.fiap.restaurantes.infra.repository.mapper.MesaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarMesaAdapter implements CadastrarMesaInterface {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;

    @Override
    public Mesa cadastrarMesa(Mesa mesa) {
        MesaEntity mesaEntity = mesaEntityMapper.toMesaEntity(mesa);
        return mesaEntityMapper.toMesa(mesaRepository.save(mesaEntity));
    }
}