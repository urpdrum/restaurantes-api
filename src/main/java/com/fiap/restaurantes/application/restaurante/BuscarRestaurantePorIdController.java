package com.fiap.restaurantes.application.restaurante;

import com.fiap.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class BuscarRestaurantePorIdController {

    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;
    private final RestauranteMapper restauranteMapper;

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteResponse> buscarRestaurantePorId(@PathVariable Long id) {
        RestauranteResponse restauranteResponse = restauranteMapper.toRestauranteResponse(buscarRestaurantePorIdUseCase.buscarRestaurantePorId(id));
        return ResponseEntity.status(HttpStatus.OK).body(restauranteResponse);
    }
}
