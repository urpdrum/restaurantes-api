package com.fiap.restaurantes.application.reserva;

import com.fiap.restaurantes.domain.mapper.reserva.ReservaMapper;
import com.fiap.restaurantes.domain.output.reserva.ReservaResponse;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservaPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class BuscarReservaPorIdController {

    private final BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;
    private final ReservaMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> buscarReservaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toReservaResponse(buscarReservaPorIdUseCase.buscarReservaPorId(id)));
    }

}
