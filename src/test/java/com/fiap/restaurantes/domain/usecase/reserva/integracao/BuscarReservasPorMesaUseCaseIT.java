package com.fiap.restaurantes.domain.usecase.reserva.integracao;

import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class BuscarReservasPorMesaUseCaseIT {

    @Autowired
    private BuscarReservasPorMesaUseCase buscarReservasPorMesaUseCase;

    @Test
    void devePermitirBuscarReservasPorMesa() {
        var mesaId = 1L;

        var listObtida = buscarReservasPorMesaUseCase.buscarReservasPorMesa(mesaId);

        assertThat(listObtida).isNotEmpty().hasSize(2);
    }
}
