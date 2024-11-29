package com.fiap.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;
import com.fiap.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.restaurantes.infra.repository.AvaliacaoRepository;
import com.fiap.restaurantes.infra.repository.mapper.AvaliacaoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BuscarAvaliacoesPorUsuarioAdapter implements BuscarAvaliacoesPorUsuarioInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoEntityMapper mapper;

    @Override
    public List<Avaliacao> buscarAvaliacoesPorUsuario(Long usuarioId) {
        List<AvaliacaoEntity> avaliacaoEntities = avaliacaoRepository.buscarPorUsuario(usuarioId);
        return avaliacaoEntities.stream().map(mapper::toAvaliacao).toList();
    }
}
