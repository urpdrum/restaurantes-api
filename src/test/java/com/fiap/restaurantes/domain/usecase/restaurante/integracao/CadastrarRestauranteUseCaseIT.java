package com.fiap.restaurantes.domain.usecase.restaurante.integracao;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.usecase.restaurante.CadastrarRestauranteUseCase;
import com.fiap.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CadastrarRestauranteUseCaseIT {

    @Autowired
    private CadastrarRestauranteUseCase cadastrarRestauranteUseCase;

    @Test
    void deveCadastrarRestaurante() {
        // Arrange
        Restaurante restaurante = RestauranteHelper.gerarRestauranteValido();

        // Act
        Restaurante restauranteSalvo = cadastrarRestauranteUseCase.cadastrarRestaurante(restaurante);

        // Assert
        assertThat(restauranteSalvo)
                .isNotNull()
                .isInstanceOf(Restaurante.class);

        assertThat(restauranteSalvo.getRestauranteId())
                .isNotNull()
                .isPositive();

        assertThat(restauranteSalvo.getNome())
                .isEqualTo(restaurante.getNome());

    }

    @Test
    void deveGerarExcecao_QuandoCadastrarRestaurante_CepNaoEncontrado() {
        var restaurante = RestauranteHelper.gerarRestauranteValido();
        restaurante.getEndereco().setCep("12345678");
        var mensagemException = "CEP inexistente.";

        assertThatThrownBy(() -> cadastrarRestauranteUseCase.cadastrarRestaurante(restaurante))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemException);
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarRestaurante_NomeNaoInformado() {
        var restaurante = RestauranteHelper.gerarRestauranteValido();
        restaurante.setNome(null);
        var mensagemException = "O nome do restaurante deve ser informado.";


        assertThatThrownBy(() -> cadastrarRestauranteUseCase.cadastrarRestaurante(restaurante))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemException);
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarRestaurante_CapacidadeNaoInformado() {
        var restaurante = RestauranteHelper.gerarRestauranteValido();
        restaurante.setCapacidade(null);
        var mensagemException = "A capacidade do restaurante deve ser informada.";


        assertThatThrownBy(() -> cadastrarRestauranteUseCase.cadastrarRestaurante(restaurante))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemException);
    }
}
