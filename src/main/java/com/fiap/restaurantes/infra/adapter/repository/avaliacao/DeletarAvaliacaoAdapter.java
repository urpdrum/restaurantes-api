package com.fiap.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;
import com.fiap.restaurantes.infra.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeletarAvaliacaoAdapter implements DeletarAvaliacaoInterface {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public boolean deletarAvaliacao(Long avaliacaoId) {
        avaliacaoRepository.deleteById(avaliacaoId);
        return true;
    }
}
