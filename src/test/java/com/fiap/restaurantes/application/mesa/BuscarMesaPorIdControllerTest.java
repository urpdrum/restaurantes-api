package com.fiap.restaurantes.application.mesa;

import com.fiap.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import com.fiap.restaurantes.utils.generic.JsonStringHelper;
import com.fiap.restaurantes.utils.mesa.MesaHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BuscarMesaPorIdControllerTest {

  @Mock
  private MesaMapper mapper;

  @Mock
  private BuscarMesaPorIdUseCase buscarMesaPorId;

  private MockMvc mockMvc;

  AutoCloseable openMocks;

  @BeforeEach
  void setUp() {
    openMocks = MockitoAnnotations.openMocks(this);
    BuscarMesaPorIdController controller = new BuscarMesaPorIdController(mapper, buscarMesaPorId);
    mockMvc = MockMvcBuilders.standaloneSetup(controller)
        .addFilter((request, response, chain) -> {
          response.setCharacterEncoding("UTF-8");
          chain.doFilter(request, response);
        })
        .setControllerAdvice(new GlobalExceptionHandler())
        .build();
  }

  @AfterEach
  void tearDown() throws Exception {
    openMocks.close();
  }

  @Test
  void deveBuscarMesaPorId() throws Exception {
    Long id = 1L;
    Mesa mesa = MesaHelper.gerarMesa();
    mesa.setMesaId(id);
    MesaResponse mesaResponse = MesaHelper.gerarMesaResponse(mesa);

    when(buscarMesaPorId.buscarMesaPorId(any(Long.class))).thenReturn(mesa);
    when(mapper.toMesaResponse(any(Mesa.class))).thenReturn(mesaResponse);

    mockMvc.perform(
        get("/mesas/{id}", id)
        .content(JsonStringHelper.asJsonString(mesaResponse))
        .contentType(MediaType.APPLICATION_JSON)
    )
        
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.restauranteId").value(mesa.getRestaurante().getRestauranteId()))
        .andExpect(jsonPath("$.capacidade").value(mesa.getQuantidadeAssentos()));

    verify(buscarMesaPorId, times(1)).buscarMesaPorId(any(Long.class));
    verify(mapper, times(1)).toMesaResponse(any(Mesa.class));
  }

  @Test
  void deveGerarExcecao_QuandoBuscarMesaPorId_IdNaoExiste() throws Exception {
    Long id = 1L;

    when(buscarMesaPorId.buscarMesaPorId(any(Long.class))).thenThrow(new MesaNotFoundException("Mesa de id: " + id + " não encontrada"));

    mockMvc.perform(
        get("/mesas/{id}", id)
        .contentType(MediaType.APPLICATION_JSON)
    )
        
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.erro").value("Mesa de id: " + id + " não encontrada"))
        .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
        .andExpect(jsonPath("$.horario").exists())
        .andExpect(jsonPath("$.rota").value("/mesas/" + id));

    verify(buscarMesaPorId, times(1)).buscarMesaPorId(any(Long.class));
    verify(mapper, never()).toMesaResponse(any(Mesa.class));

  }
}
