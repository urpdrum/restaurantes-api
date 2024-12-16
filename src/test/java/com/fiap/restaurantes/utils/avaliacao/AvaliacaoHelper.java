package com.fiap.restaurantes.utils.avaliacao;

import com.fiap.restaurantes.domain.entity.Avaliacao;
import com.fiap.restaurantes.domain.input.avaliacao.AtualizarAvaliacaoRequest;
import com.fiap.restaurantes.domain.input.avaliacao.CadastrarAvaliacaoRequest;
import com.fiap.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
import com.fiap.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.restaurantes.utils.restaurante.RestauranteHelper;
import com.fiap.restaurantes.utils.usuario.UsuarioHelper;

public class AvaliacaoHelper {

    public static AvaliacaoEntity gerarAvaliacaoEntity() {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();

        avaliacao.setUsuarioEntity(UsuarioHelper.gerarUsuarioEntity());
        avaliacao.setRestauranteEntity(RestauranteHelper.gerarRestauranteEntityValido());
        avaliacao.setNota(5);
        avaliacao.setComentario("Comentário teste");
        return avaliacao;
    }

    public static Avaliacao gerarAvaliacao() {
        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setUsuario(UsuarioHelper.gerarUsuarioValidoComId());
        avaliacao.setRestaurante(RestauranteHelper.gerarRestauranteValido());
        avaliacao.setNota(5);
        avaliacao.setComentario("Comentário teste");
        return avaliacao;
    }

    public static AvaliacaoResponse gerarAvaliacaoResponse() {
        return new AvaliacaoResponse(
                1L,
                1L,
                1L,
                1,
                "Horrivel"
        );
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequest() {
        return new CadastrarAvaliacaoRequest(
                1L,
                1L,
                4,
                "Muito Bom"
        );
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequestRestauranteInexistente() {
        return new CadastrarAvaliacaoRequest(
                151984515588L,
                1L,
                4,
                "Muito Bom"
        );
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequestUsuarioInexistente() {
        return new CadastrarAvaliacaoRequest(
                1L,
                51658495122L,
                4,
                "Muito Bom"
        );
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequestNotaInvalida() {
        return new CadastrarAvaliacaoRequest(
                1L,
                1L,
                15522,
                "Muito Bom"
        );
    }

    public static AtualizarAvaliacaoRequest gerarAtualizarAvaliacaoRequest() {
        return new AtualizarAvaliacaoRequest(
                1,
                "Horrivel"
        );
    }

    public static AtualizarAvaliacaoRequest gerarAtualizarAvaliacaoRequestComNotaInvalida() {
        return new AtualizarAvaliacaoRequest(
                18,
                "Horrivel"
        );
    }
}
