package com.fiap.restaurantes.application.reserva;

import com.fiap.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.mapper.reserva.ReservaMapper;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorUsuarioUseCase;
import com.fiap.restaurantes.utils.reserva.ReservaHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BuscarReservasPorUsuarioControllerTest {

    @Mock
    private BuscarReservasPorUsuarioUseCase buscarReservasPorUsuarioUseCase;

    @Mock
    private ReservaMapper mapper;

    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        BuscarReservasPorUsuarioController controller = new BuscarReservasPorUsuarioController(buscarReservasPorUsuarioUseCase, mapper);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarReservasPorUsuario() throws Exception {
        var reserva1 = ReservaHelper.gerarReserva();
        var reserva2 = ReservaHelper.gerarReserva();
        var listReserva = Arrays.asList(reserva1, reserva2);
        var response = ReservaHelper.gerarReservaResponse();
        var usuarioId = 1L;
        when(buscarReservasPorUsuarioUseCase.buscarReservasPorUsuario(anyLong())).thenReturn(listReserva);
        when(mapper.toReservaResponse(any(Reserva.class))).thenReturn(response);

        mockMvc.perform(get("/reservas/usuario")
                        .param("usuarioId", String.valueOf(usuarioId)))
                
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(listReserva.size()))
                .andExpect(jsonPath("$[0].status").value(response.status().toString()))
                .andExpect(jsonPath("$[0].usuarioId").value(response.usuarioId()))
                .andExpect(jsonPath("$[0].mesaId").value(response.mesaId()))
                .andExpect(jsonPath("$[0].dataInicio").exists())
                .andExpect(jsonPath("$[0].dataFim").exists());
        verify(buscarReservasPorUsuarioUseCase, times(1)).buscarReservasPorUsuario(anyLong());
        verify(mapper, times(2)).toReservaResponse(any(Reserva.class));
    }
}
