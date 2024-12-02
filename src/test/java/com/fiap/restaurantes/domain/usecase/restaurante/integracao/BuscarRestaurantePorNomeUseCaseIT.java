package com.fiap.restaurantes.domain.usecase.restaurante.integracao;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorNomeUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class BuscarRestaurantePorNomeUseCaseIT {

    @Autowired
    private BuscarRestaurantePorNomeUseCase useCase;

    @Test
    void devePermitirbuscarRestaurantePorLocalidade() {
        String nome = "restaurante teste";

        //Act
        List<Restaurante> resultado = useCase.buscarRestaurantePorNome(nome);

        // Assert
        assertThat(resultado)
                .hasSizeGreaterThan(5);
    }
}