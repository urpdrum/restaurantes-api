package com.fiap.restaurantes.utils.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.restaurantes.domain.output.usuario.UsuarioDeletadoResponse;
import com.fiap.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.restaurantes.infra.entity.UsuarioEntity;

public class UsuarioHelper {
  public static UsuarioDeletadoResponse gerarUsuarioDeletadoReponse() {
    return new UsuarioDeletadoResponse(true);
  }

  public static CadastrarUsuarioRequest gerarCadastrarUsuarioRequest() {
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c8";
    return new CadastrarUsuarioRequest(nome, email, senha, telefone);
  }

  public static UsuarioResponse gerarUsuarioResponse() {
    Long id = 1L;
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "aA@45jg8";
    return new UsuarioResponse(id, nome, email, senha, telefone);
  }

  public static UsuarioResponse gerarUsuarioResponseAtualizado() {
    Long id = 1L;
    String nome = "Jorge";
    String email = "Renato@mail.com";
    String telefone = "00000000001";
    String senha = "Fd@7rt43";
    return new UsuarioResponse(id, nome, email, senha, telefone);
  }

  public static AtualizarUsuarioRequest gerarAtualizarUsuarioRequest() {
    String nome = "Maria";
    String email = "Renato@mail.com";
    String telefone = "00000000001";
    String senha = "Ui@7rs85";
    return new AtualizarUsuarioRequest(nome, email, senha, telefone);
  }


  public static Usuario gerarUsuarioValidoComId() {
    Long id = 1L;
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "ao@4j7c8";
    Usuario usuario = new Usuario(nome, email, senha, telefone);
    usuario.setUsuarioId(id);
    return usuario;
  }

  public static Usuario gerarUsuarioValido() {
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "jK@4b7c8";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static UsuarioEntity gerarUsuarioEntity() {
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c8";
    return  new UsuarioEntity(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComNomeVazio() {
    String nome = "";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComEmailInvalido() {
    String nome = "Renato";
    String email = "Renato.com";
    String telefone = "000000000";
    String senha = "aA@4b7c";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComSenhaInvalida() {
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "000000000";
    String senha = "123senhainvalida";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComTelefoneVazio() {
    String nome = "Renato";
    String email = "Renato@mail.com";
    String telefone = "";
    String senha = "123senhainvalida";
    return  new Usuario(nome, email, senha, telefone);
  }
}
