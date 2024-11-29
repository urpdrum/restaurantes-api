package com.fiap.restaurantes.infra.adapter.repository.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaEPeriodoInterface;
import com.fiap.restaurantes.infra.repository.ReservaRepository;
import com.fiap.restaurantes.infra.repository.mapper.ReservaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarReservasPorMesaEPeriodoAdapter implements BuscarReservasPorMesaEPeriodoInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper mapper;

    @Override
    public List<Reserva> buscarReservasPorMesaEPeriodo(Long mesaId, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return reservaRepository.buscarReservasPorMesaEPeriodo(mesaId, dataInicio, dataFim)
                .stream()
                .map(mapper::toReserva)
                .toList();
    }
}
