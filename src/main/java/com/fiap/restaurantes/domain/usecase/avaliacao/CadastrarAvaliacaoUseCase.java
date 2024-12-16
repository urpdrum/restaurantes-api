package com.fiap.restaurantes.domain.usecase.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.entity.Restaurante;

import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.entity.validation.avaliacao.AvaliacaoValidator;
import com.fiap.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import com.fiap.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;

public class CadastrarAvaliacaoUseCase {

    private final CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;

    public CadastrarAvaliacaoUseCase(CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase, BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
        this.cadastrarAvaliacaoInterface = cadastrarAvaliacaoInterface;
        this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
        this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
    }

    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao, Long restauranteId, Long usuarioId) {

        //Valida se Usuario existe
        Usuario usuario = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(usuarioId);
        //Valida se Restaurate existe
        Restaurante restaurante = buscarRestaurantePorIdUseCase.buscarRestaurantePorId(restauranteId);

        avaliacao.setUsuario(usuario);
        avaliacao.setRestaurante(restaurante);

        AvaliacaoValidator.validate(avaliacao);

        return cadastrarAvaliacaoInterface.cadastraAvaliacao(avaliacao);
    }
}
