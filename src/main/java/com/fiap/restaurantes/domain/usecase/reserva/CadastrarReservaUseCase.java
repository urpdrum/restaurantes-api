package com.fiap.restaurantes.domain.usecase.reserva;

import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.entity.Reserva;

import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.entity.validation.reserva.ReservaValidator;
import com.fiap.restaurantes.domain.enums.StatusReservaEnum;
import com.fiap.restaurantes.domain.gateway.reserva.CadastrarReservaInterface;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import com.fiap.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;

import java.util.List;

public class CadastrarReservaUseCase {

    private final CadastrarReservaInterface cadastrarReservaInterface;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
    private final BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
    private final BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase;

    public CadastrarReservaUseCase(CadastrarReservaInterface cadastrarReservaInterface,
                                   BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
                                   BuscarMesaPorIdUseCase buscarMesaPorIdUseCase,
                                   BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase) {
        this.cadastrarReservaInterface = cadastrarReservaInterface;
        this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
        this.buscarMesaPorIdUseCase = buscarMesaPorIdUseCase;
        this.buscarReservasPorMesaEPeriodoUseCase = buscarReservasPorMesaEPeriodoUseCase;
    }

    public Reserva cadastrarReserva(Reserva reserva, Long usuarioId, Long mesaId) {

        Usuario usuario = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(usuarioId);
        Mesa mesa = buscarMesaPorIdUseCase.buscarMesaPorId(mesaId);

        reserva.setUsuario(usuario);
        reserva.setMesa(mesa);
        reserva.setStatus(StatusReservaEnum.ATIVA);

        ReservaValidator.validate(reserva);

        List<Reserva> reservaList = buscarReservasPorMesaEPeriodoUseCase.buscarReservasPorMesaEPeriodo(mesaId,
                reserva.getDataInicio(),
                reserva.getDataFim());

        if (!reservaList.isEmpty()) {
            throw new IllegalStateException("A Mesa de id: " + mesaId + " já está reservada no período selecionado.");
        }

        return cadastrarReservaInterface.cadastrarReserva(reserva);
    }
}
