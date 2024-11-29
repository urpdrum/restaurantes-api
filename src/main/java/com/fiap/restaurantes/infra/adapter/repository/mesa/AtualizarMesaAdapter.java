package com.fiap.restaurantes.infra.adapter.repository.mesa;


import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.AtualizarMesaInterface;
import com.fiap.restaurantes.infra.entity.MesaEntity;
import com.fiap.restaurantes.infra.repository.MesaRepository;
import com.fiap.restaurantes.infra.repository.mapper.MesaEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarMesaAdapter implements AtualizarMesaInterface {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;

    @Transactional
    @Override
    public Mesa atualizarMesa(Mesa mesa) {
        MesaEntity mesaEntity = mesaEntityMapper.toMesaEntity(mesa);

        return mesaEntityMapper.toMesa(mesaRepository.save(mesaEntity));
    }
}