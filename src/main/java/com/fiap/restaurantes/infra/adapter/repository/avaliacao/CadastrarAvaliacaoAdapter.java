package com.fiap.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.restaurantes.infra.repository.AvaliacaoRepository;
import com.fiap.restaurantes.infra.repository.mapper.AvaliacaoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarAvaliacaoAdapter implements CadastrarAvaliacaoInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoEntityMapper mapper;

    @Override
    public Avaliacao cadastraAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity avaliacaoEntity = avaliacaoRepository.save(mapper.toAvaliacaoEntity(avaliacao));
        return mapper.toAvaliacao(avaliacaoEntity);
    }
}
