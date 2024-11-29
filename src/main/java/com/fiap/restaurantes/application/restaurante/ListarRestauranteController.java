package com.fiap.restaurantes.application.restaurante;

import com.fiap.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.restaurantes.domain.usecase.restaurante.ListarRestauranteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class ListarRestauranteController {

    private final RestauranteMapper restauranteMapper;
    private final ListarRestauranteUseCase listarRestauranteUseCase;

    @GetMapping
    public ResponseEntity<List<RestauranteResponse>> listarRestaurantes() {
        List<RestauranteResponse> listaRestaurante = listarRestauranteUseCase.listarRestaurantes()
                .stream()
                .map(restauranteMapper::toRestauranteResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(listaRestaurante);
    }
}
