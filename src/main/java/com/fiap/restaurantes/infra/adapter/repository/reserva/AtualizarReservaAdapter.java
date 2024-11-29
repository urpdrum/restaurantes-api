package com.fiap.restaurantes.infra.adapter.repository.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.gateway.reserva.AtualizarReservaInterface;
import com.fiap.restaurantes.infra.entity.ReservaEntity;
import com.fiap.restaurantes.infra.repository.ReservaRepository;
import com.fiap.restaurantes.infra.repository.mapper.ReservaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AtualizarReservaAdapter implements AtualizarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper mapper;

    @Override
    public Reserva atualizarReserva(Reserva reserva) {
        ReservaEntity entity = mapper.toReservaEntity(reserva);

        return mapper.toReserva(reservaRepository.save(entity));
    }
}
