package com.fiap.restaurantes.application.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.input.avaliacao.AtualizarAvaliacaoRequest;
import com.fiap.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
import com.fiap.restaurantes.domain.usecase.avaliacao.AtualizarAvaliacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AtualizarAvaliacaoController {

    private final AvaliacaoMapper avaliacaoMapper;
    private final AtualizarAvaliacaoUseCase atualizarAvaliacaoUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> atualizarAvaliacao(@PathVariable("id") Long id,
                                                                @RequestBody AtualizarAvaliacaoRequest atualizarAvaliacaoRequest) {
        Avaliacao avaliacao = avaliacaoMapper.toAvaliacao(atualizarAvaliacaoRequest);

        AvaliacaoResponse avaliacaoResponse = avaliacaoMapper.toAvaliacaoResponse(atualizarAvaliacaoUseCase.atualizarAvaliacao(id, avaliacao));

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoResponse);
    }
}
