package com.fiap.restaurantes.domain.exception.mesa;

public class MesaNotFoundException extends RuntimeException {
    public MesaNotFoundException(String message) {
        super(message);
    }
}
