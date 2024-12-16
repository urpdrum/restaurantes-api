package com.fiap.restaurantes.application.reserva;

import com.fiap.restaurantes.domain.mapper.reserva.ReservaMapper;
import com.fiap.restaurantes.domain.output.reserva.ReservaResponse;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class BuscarReservasPorMesaController {

    private final BuscarReservasPorMesaUseCase buscarReservasPorMesaUseCase;
    private final ReservaMapper mapper;

    @GetMapping("/mesa")
    public ResponseEntity<List<ReservaResponse>> buscarReservasPorMesa(@RequestParam Long mesaId) {
        List<ReservaResponse> responseList = buscarReservasPorMesaUseCase.buscarReservasPorMesa(mesaId)
                .stream()
                .map(mapper::toReservaResponse)
                .toList();
        return ResponseEntity.ok(responseList);
    }
}
