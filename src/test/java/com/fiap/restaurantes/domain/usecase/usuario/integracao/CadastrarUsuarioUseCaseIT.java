package com.fiap.restaurantes.domain.usecase.usuario.integracao;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.usecase.usuario.CadastrarUsuarioUseCase;
import com.fiap.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CadastrarUsuarioUseCaseIT {
  @Autowired
  private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

  @Test
  void deveCadastrarUsuario() {
    // Arrange
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();

    // Act
    Usuario usuarioSalvo = cadastrarUsuarioUseCase.cadastrarUsuario(usuario);

    // Assert
    assertThat(usuarioSalvo)
        .isNotNull()
        .isInstanceOf(Usuario.class);

    assertThat(usuarioSalvo.getUsuarioId())
        .isNotNull()
        .isPositive();

    assertThat(usuarioSalvo.getNome())
        .isEqualTo(usuario.getNome());

    assertThat(usuarioSalvo.getEmail())
        .isEqualTo(usuario.getEmail());

    assertThat(usuarioSalvo.getSenha())
        .isEqualTo(usuario.getSenha());

    assertThat(usuarioSalvo.getTelefone())
        .isEqualTo(usuario.getTelefone());
  }
}
