package com.fiap.restaurantes.application.handler;

import com.fiap.restaurantes.application.handler.exception.ErroCustomizado;
import com.fiap.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.exception.reserva.ReservaNotFoundException;
import com.fiap.restaurantes.domain.exception.restaurante.RestauranteNotFoundException;
import com.fiap.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestauranteNotFoundException.class)
    public ResponseEntity<ErroCustomizado> restauranteNotFoundException(RestauranteNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErroCustomizado> handleUsuarioNotFoundException(UsuarioNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(AvaliacaoNotFoundException.class)
    public ResponseEntity<ErroCustomizado> handleAvaliacaoNotFoundException(AvaliacaoNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(MesaNotFoundException.class)
    public ResponseEntity<ErroCustomizado> handleMesaNotFoundException(MesaNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(ReservaNotFoundException.class)
    public ResponseEntity<ErroCustomizado> handleReservaNotFoundException(ReservaNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroCustomizado> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErroCustomizado> handleIllegalStateException(IllegalStateException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }
}
