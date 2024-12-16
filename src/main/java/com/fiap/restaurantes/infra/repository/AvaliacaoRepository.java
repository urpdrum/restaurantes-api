package com.fiap.restaurantes.infra.repository;

import com.fiap.restaurantes.infra.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {

    @Query("SELECT a FROM AvaliacaoEntity a WHERE a.restauranteEntity.restauranteId = :restauranteId")
    List<AvaliacaoEntity> buscarPorRestaurante(Long restauranteId);

    @Query("SELECT a FROM AvaliacaoEntity a WHERE a.usuarioEntity.usuarioId = :usuarioId")
    List<AvaliacaoEntity> buscarPorUsuario(Long usuarioId);

}
