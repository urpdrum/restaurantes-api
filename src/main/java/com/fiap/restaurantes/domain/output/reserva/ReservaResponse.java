package com.fiap.restaurantes.domain.output.reserva;

import com.fiap.restaurantes.domain.enums.StatusReservaEnum;

import java.time.LocalDateTime;

public record ReservaResponse(
        Long reservaId,
        Long mesaId,
        Long usuarioId,
        StatusReservaEnum status,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
}
