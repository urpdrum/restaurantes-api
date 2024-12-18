package com.fiap.restaurantes.application.usuario;


import com.fiap.restaurantes.domain.entity.validation.Usuario;
import com.fiap.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.restaurantes.domain.usecase.usuario.AtualizarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class AtualizarUsuarioController {

    private final UsuarioMapper usuarioMapper;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable Long id,
                                                            @RequestBody AtualizarUsuarioRequest usuarioRequest) {
        Usuario usuarioAtualizado = atualizarUsuarioUseCase.atualizarUsuario(id, usuarioMapper.toUsuario(usuarioRequest));
        UsuarioResponse usuarioResponse = usuarioMapper.toUsuarioResponse(usuarioAtualizado);

        return ResponseEntity.ok(usuarioResponse);
    }
}
