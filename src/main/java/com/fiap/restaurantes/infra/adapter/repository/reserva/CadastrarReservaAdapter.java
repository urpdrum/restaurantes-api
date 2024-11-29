package com.fiap.restaurantes.infra.adapter.repository.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.gateway.reserva.CadastrarReservaInterface;
import com.fiap.restaurantes.infra.repository.ReservaRepository;
import com.fiap.restaurantes.infra.repository.mapper.ReservaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarReservaAdapter implements CadastrarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper mapper;

    @Override
    public Reserva cadastrarReserva(Reserva reserva) {
        return mapper.toReserva(reservaRepository.save(mapper.toReservaEntity(reserva)));
    }
}
