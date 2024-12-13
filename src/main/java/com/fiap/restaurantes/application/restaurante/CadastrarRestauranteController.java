package com.fiap.restaurantes.application.restaurante;

import com.fiap.restaurantes.domain.entity.Restaurante;
import com.fiap.restaurantes.domain.input.restaurante.CadastrarRestauranteRequest;
import com.fiap.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.restaurantes.domain.usecase.restaurante.CadastrarRestauranteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(value = "/restaurantes")
@RequiredArgsConstructor
public class CadastrarRestauranteController {

    private final RestauranteMapper restauranteMapper;
    private final CadastrarRestauranteUseCase cadastrarRestauranteUseCase;

    @PostMapping
    public ResponseEntity<RestauranteResponse> cadastrarRestaurante(@RequestBody CadastrarRestauranteRequest request) {

        Restaurante restaurante = restauranteMapper.toRestaurante(request);

        RestauranteResponse restauranteResponse = restauranteMapper.toRestauranteResponse(cadastrarRestauranteUseCase.cadastrarRestaurante(restaurante));

        URI uri = fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(restauranteResponse.restauranteId())
                .toUri();
        return ResponseEntity.created(uri).body(restauranteResponse);
    }
}
