package com.fiap.restaurantes.application.restaurante;

import com.fiap.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorNomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class BuscarRestaurantePorNomeController {

    private final RestauranteMapper restauranteMapper;
    private final BuscarRestaurantePorNomeUseCase buscarRestaurantePorNomeUseCase;

    @GetMapping("/nome")
    public ResponseEntity<List<RestauranteResponse>> buscarRestaurantesPorNome(@RequestParam String nome) {
        List<RestauranteResponse> listaRestaurantePorNome = buscarRestaurantePorNomeUseCase.buscarRestaurantePorNome(nome)
                .stream()
                .map(restauranteMapper::toRestauranteResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(listaRestaurantePorNome);
    }
}
