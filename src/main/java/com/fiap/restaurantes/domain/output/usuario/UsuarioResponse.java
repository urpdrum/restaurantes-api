package com.fiap.restaurantes.domain.output.usuario;

public record UsuarioResponse(
    Long usuarioId,
    String nome,
    String email,
    String senha,
    String telefone
) {
}
