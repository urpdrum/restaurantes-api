package com.fiap.restaurantes.application.mesa;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.input.mesa.AtualizarMesaRequest;
import com.fiap.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.restaurantes.domain.usecase.mesa.AtualizarMesaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesas")
public class AtualizarMesaController {

    private final MesaMapper mesaMapper;
    private final AtualizarMesaUseCase atualizarMesaUseCase;

    public AtualizarMesaController(MesaMapper mesaMapper, AtualizarMesaUseCase atualizarMesaUseCase) {
        this.mesaMapper = mesaMapper;
        this.atualizarMesaUseCase = atualizarMesaUseCase;
    }

    @PutMapping("/{mesaId}")
    public ResponseEntity<MesaResponse> atualizarMesa(@PathVariable Long mesaId,
                                                      @RequestBody AtualizarMesaRequest mesaRequest) {
        Mesa mesaAtualizada = atualizarMesaUseCase.atualizarMesa(mesaId, mesaMapper.toMesa(mesaRequest));
        MesaResponse mesaResponse = mesaMapper.toMesaResponse(mesaAtualizada);

        return ResponseEntity.ok(mesaResponse);
    }
}