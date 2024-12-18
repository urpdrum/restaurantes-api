package com.fiap.restaurantes.domain.usecase.reserva.integracao;

import com.fiap.restaurantes.domain.exception.reserva.ReservaNotFoundException;
import com.fiap.restaurantes.domain.usecase.reserva.DeletarReservaUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class DeletarReservaUseCaseIT {

    @Autowired
    private DeletarReservaUseCase deletarReservaUseCase;

    @Test
    void devePermitirDeletarReserva() {
        var id = 4L;

        var reservaDeletada = deletarReservaUseCase.deletarReserva(id);
        assertThat(reservaDeletada).isTrue();
    }

    @Test
    void deveGerarExcecao_QuandoDeletarReserva_IdNaoEncontrado() {
        var id = 123456798L;
        var mensagemException = "Reserva de id: " + id + " não encontrada.";

        assertThatThrownBy(() -> deletarReservaUseCase.deletarReserva(id))
                .isInstanceOf(ReservaNotFoundException.class)
                .hasMessage(mensagemException);
    }
}
