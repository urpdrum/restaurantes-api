package com.fiap.restaurantes.application.mesa;

import com.fiap.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.input.mesa.AtualizarMesaRequest;
import com.fiap.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.restaurantes.domain.usecase.mesa.AtualizarMesaUseCase;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AtualizarMesaControllerTest {
  @Mock
  private MesaMapper mapper;

  @Mock
  private AtualizarMesaUseCase atualizarMesaUseCase;

  MockMvc mockMvc;

  AutoCloseable openMocks;

  @BeforeEach
  void setUp() {
    openMocks = MockitoAnnotations.openMocks(this);
    AtualizarMesaController controller = new AtualizarMesaController(mapper, atualizarMesaUseCase);
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
  void devePermitirAtualizarMesa() throws Exception {
    Long id = 1L;
    Integer novaQuantidadeAssentos = 8;

    AtualizarMesaRequest request = MesaHelper.gerarAtualizarMesaRequest(novaQuantidadeAssentos);

    Mesa mesa = MesaHelper.gerarMesa();
    mesa.setMesaId(id);
    mesa.setQuantidadeAssentos(novaQuantidadeAssentos);

    MesaResponse response = MesaHelper.gerarMesaResponse(mesa);

    when(mapper.toMesa(any(AtualizarMesaRequest.class))).thenReturn(mesa);
    when(atualizarMesaUseCase.atualizarMesa(any(Long.class), any(Mesa.class))).thenAnswer(answer -> answer.getArgument(1));
    when(mapper.toMesaResponse(any(Mesa.class))).thenReturn(response);

    mockMvc.perform(
        put("/mesas/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonStringHelper.asJsonString(request))
    )
        
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.capacidade").value(novaQuantidadeAssentos));

    verify(mapper, times(1)).toMesa(any(AtualizarMesaRequest.class));
    verify(mapper, times(1)).toMesaResponse(any(Mesa.class));
    verify(atualizarMesaUseCase, times(1)).atualizarMesa(any(Long.class), any(Mesa.class));
  }

  @Test
  void deveGerarExcecao_QuandoAtualizarMesa_IdDaMesaNaoExiste() throws Exception {
    Long id = 1L;
    Integer novaQuantidadeAssentos = 8;

    Mesa mesa = MesaHelper.gerarMesa();
    mesa.setMesaId(id);
    mesa.setQuantidadeAssentos(novaQuantidadeAssentos);

    AtualizarMesaRequest request = MesaHelper.gerarAtualizarMesaRequest(novaQuantidadeAssentos);

    when(mapper.toMesa(any(AtualizarMesaRequest.class))).thenReturn(mesa);
    when(atualizarMesaUseCase.atualizarMesa(any(Long.class), any(Mesa.class))).thenThrow(new MesaNotFoundException("Mesa de id: " + id + " não encontrada"));

    mockMvc.perform(
        put("/mesas/{id}", id)
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonStringHelper.asJsonString(request))
    )
        
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.erro").value("Mesa de id: " + id + " não encontrada"))
        .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
        .andExpect(jsonPath("$.horario").exists())
        .andExpect(jsonPath("$.rota").value("/mesas/" + id));

    verify(mapper, times(1)).toMesa(any(AtualizarMesaRequest.class));
    verify(mapper, never()).toMesaResponse(any(Mesa.class));
    verify(atualizarMesaUseCase).atualizarMesa(any(Long.class), any(Mesa.class));

  }
}
