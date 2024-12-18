package com.fiap.restaurantes.domain.usecase.restaurante.integracao;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.exception.restaurante.RestauranteNotFoundException;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BuscarRestaurantePorIdUseCaseIT {

    @Autowired
    private BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;


    @Test
    void devePermitirBuscarRestaurantePorId() {
        var id = 1L;

        var restauranteObtido = buscarRestaurantePorIdUseCase.buscarRestaurantePorId(id);

        assertThat(restauranteObtido)
                .isNotNull()
                .isInstanceOf(Restaurante.class);
        assertThat(restauranteObtido.getRestauranteId()).isEqualTo(id);
    }

    @Test
    void deveGerarExcecao_QuandoBuscarRestaurantePorId_IdNaoEncontrado() {
        var id = 1123456L;
        var mensagemException = "Restaurante de id: " + id + " não encontrado.";

        assertThatThrownBy(() -> buscarRestaurantePorIdUseCase.buscarRestaurantePorId(id))
                .isInstanceOf(RestauranteNotFoundException.class)
                .hasMessage(mensagemException);
    }
}
