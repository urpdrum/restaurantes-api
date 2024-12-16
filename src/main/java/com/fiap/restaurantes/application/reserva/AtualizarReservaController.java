package com.fiap.restaurantes.application.reserva;

import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.input.reserva.AtualizarReservaRequest;
import com.fiap.restaurantes.domain.mapper.reserva.ReservaMapper;
import com.fiap.restaurantes.domain.output.reserva.ReservaResponse;
import com.fiap.restaurantes.domain.usecase.reserva.AtualizarReservaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class AtualizarReservaController {

    private final AtualizarReservaUseCase atualizarReservaUseCase;
    private final ReservaMapper mapper;

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponse> atualizarReserva(@PathVariable Long id, @RequestBody AtualizarReservaRequest request) {
        Reserva reserva = atualizarReservaUseCase.atualizarReserva(id, mapper.toReserva(request));
        return ResponseEntity.ok(mapper.toReservaResponse(reserva));
    }
}
