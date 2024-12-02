package com.fiap.restaurantes.domain.usecase.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorLocalidadeInterface;
import com.fiap.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuscarRestaurantePorLocalidadeUseCaseTest {

    private BuscarRestaurantePorLocalidadeUseCase useCase;

    @Mock
    private BuscarRestaurantePorLocalidadeInterface buscarRestaurantePorLocalidadeInterface;

    AutoCloseable openMocks;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new BuscarRestaurantePorLocalidadeUseCase(buscarRestaurantePorLocalidadeInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirbuscarRestaurantePorLocalidade() {
        // Arrange
        Restaurante entidade1 = RestauranteHelper.gerarRestauranteValido();
        Restaurante entidade2 = RestauranteHelper.gerarRestauranteValido();

        String logradouro = "logradouro teste";

        List<Restaurante> restaurantes = Arrays.asList(entidade1, entidade2);

        when(buscarRestaurantePorLocalidadeInterface.buscarRestaurantePorLocalidade(any())).thenReturn(restaurantes);

        //Act
        List<Restaurante> resultado = useCase.buscarRestaurantePorLocalidade(logradouro);

        // Assert
        assertThat(resultado)
                .hasSize(2)
                .containsExactlyInAnyOrder(entidade1, entidade2);

        verify(buscarRestaurantePorLocalidadeInterface, times(1)).buscarRestaurantePorLocalidade(any());
    }
}