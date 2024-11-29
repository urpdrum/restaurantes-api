package com.fiap.restaurantes.application.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class BuscarMesaPorIdController {

    private final MesaMapper mesaMapper;
    private final BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<MesaResponse> buscarMesa(@PathVariable Long id) {
        Mesa mesaBuscada = buscarMesaPorIdUseCase.buscarMesaPorId(id);
        return ResponseEntity.ok(mesaMapper.toMesaResponse(mesaBuscada));
    }
}