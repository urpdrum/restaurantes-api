package com.fiap.restaurantes.infra.adapter.repository.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;
import com.fiap.restaurantes.infra.entity.MesaEntity;
import com.fiap.restaurantes.infra.repository.MesaRepository;
import com.fiap.restaurantes.infra.repository.mapper.MesaEntityMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BuscarMesaPorIdAdapter implements BuscarMesaPorIdInterface {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;
       public BuscarMesaPorIdAdapter(MesaRepository mesaRepository, MesaEntityMapper mesaEntityMapper) {
        this.mesaRepository = mesaRepository;
        this.mesaEntityMapper = mesaEntityMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Mesa buscarMesaPorId(Long id) {
        MesaEntity mesaBuscada = mesaRepository.findById(id)
                .orElse(null);
        return mesaEntityMapper.toMesa(mesaBuscada);
    }
}