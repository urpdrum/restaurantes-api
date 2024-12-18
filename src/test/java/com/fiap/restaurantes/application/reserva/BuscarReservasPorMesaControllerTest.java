package com.fiap.restaurantes.application.reserva;

import com.fiap.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.restaurantes.domain.entity.Reserva;
import com.fiap.restaurantes.domain.mapper.reserva.ReservaMapper;
import com.fiap.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaUseCase;
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

class BuscarReservasPorMesaControllerTest {

    @Mock
    private BuscarReservasPorMesaUseCase buscarReservasPorMesaUseCase;

    @Mock
    private ReservaMapper mapper;

    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        BuscarReservasPorMesaController controller = new BuscarReservasPorMesaController(buscarReservasPorMesaUseCase, mapper);
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
    void devePermitirBuscarReservasPorMesa() throws Exception {
        var reserva1 = ReservaHelper.gerarReserva();
        var reserva2 = ReservaHelper.gerarReserva();
        var listReserva = Arrays.asList(reserva1, reserva2);
        var response = ReservaHelper.gerarReservaResponse();
        var mesaId = 1L;
        when(buscarReservasPorMesaUseCase.buscarReservasPorMesa(anyLong())).thenReturn(listReserva);
        when(mapper.toReservaResponse(any(Reserva.class))).thenReturn(response);

        mockMvc.perform(get("/reservas/mesa")
                .param("mesaId", String.valueOf(mesaId)))
                
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(listReserva.size()))
                .andExpect(jsonPath("$[0].status").value(response.status().toString()))
                .andExpect(jsonPath("$[0].usuarioId").value(response.usuarioId()))
                .andExpect(jsonPath("$[0].mesaId").value(response.mesaId()))
                .andExpect(jsonPath("$[0].dataInicio").exists())
                .andExpect(jsonPath("$[0].dataFim").exists());
        verify(buscarReservasPorMesaUseCase, times(1)).buscarReservasPorMesa(anyLong());
        verify(mapper, times(2)).toReservaResponse(any(Reserva.class));
    }
}
