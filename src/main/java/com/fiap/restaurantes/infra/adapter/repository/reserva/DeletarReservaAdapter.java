package com.fiap.restaurantes.infra.adapter.repository.reserva;

import com.fiap.restaurantes.domain.gateway.reserva.DeletarReservaInterface;
import com.fiap.restaurantes.infra.repository.ReservaRepository;
import com.fiap.restaurantes.infra.repository.mapper.ReservaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarReservaAdapter implements DeletarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper mapper;

    @Override
    public boolean deletarReserva(Long reservaId) {
        reservaRepository.deleteById(reservaId);
        return true;
    }
}
