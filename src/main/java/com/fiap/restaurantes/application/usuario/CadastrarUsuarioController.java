package com.fiap.restaurantes.application.usuario;


import ch.qos.logback.core.model.Model;
import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.restaurantes.domain.usecase.usuario.CadastrarUsuarioUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/usuarios", method = RequestMethod.POST)

public class CadastrarUsuarioController {
  @Autowired
  private  UsuarioMapper usuarioMapper;
  @Autowired
  private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

  @PostMapping
  public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody CadastrarUsuarioRequest cadastrarUsuarioRequest) {
    Usuario usuario = usuarioMapper.toUsuario(cadastrarUsuarioRequest);

    Usuario usuarioCadastrado = cadastrarUsuarioUseCase.cadastrarUsuario(usuario);

    UsuarioResponse usuarioResponse = usuarioMapper.toUsuarioResponse(usuarioCadastrado);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(usuarioResponse.usuarioId())
            .toUri();

    return ResponseEntity.created(uri).body(usuarioResponse);
  }
}
