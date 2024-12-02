package com.fiap.restaurantes.domain.usecase.avaliacao.integracao;

import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorRestauranteUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class BuscarAvaliacoesPorRestauranteUseCaseIT {

    @Autowired
    private BuscarAvaliacoesPorRestauranteUseCase buscarAvaliacoesPorRestauranteUseCase;

    @Test
    void devePermitirBuscarAvaliacoesPorRestaurante() {
        var restauranteId = 1L;

        var listAvaliacoes = buscarAvaliacoesPorRestauranteUseCase.buscarAvaliacoesPorRestaurante(restauranteId);

        assertThat(listAvaliacoes)
                .isNotEmpty()
                .hasSize(2);
    }
}
