package com.fiap.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.gateway.avaliacao.AtualizarAvaliacaoInterface;
import com.fiap.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.restaurantes.infra.repository.AvaliacaoRepository;
import com.fiap.restaurantes.infra.repository.mapper.AvaliacaoEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AtualizarAvaliacaoAdapter implements AtualizarAvaliacaoInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoEntityMapper mapper;

    @Override
    @Transactional
    public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity avaliacaoEntity = mapper.toAvaliacaoEntity(avaliacao);

        return mapper.toAvaliacao(avaliacaoRepository.save(avaliacaoEntity));
    }
}
