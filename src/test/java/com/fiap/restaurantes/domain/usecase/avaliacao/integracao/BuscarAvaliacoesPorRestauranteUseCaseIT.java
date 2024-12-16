package com.fiap.restaurantes.domain.usecase.avaliacao.integracao;

import com.fiap.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorRestauranteUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;
import static org.hamcrest.MatcherAssert.assertThat;

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

        //assertThat(listAvaliacoes)
               // .isNotEmpty()
              //  .hasSize(2);
    }
}
