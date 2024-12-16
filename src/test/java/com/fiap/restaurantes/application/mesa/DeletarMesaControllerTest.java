package com.fiap.restaurantes.application.mesa;

import com.fiap.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.restaurantes.domain.exception.mesa.MesaNotFoundException;
import com.fiap.restaurantes.domain.output.mesa.MesaDeletadaResponse;
import com.fiap.restaurantes.domain.usecase.mesa.DeletarMesaUseCase;
import com.fiap.restaurantes.utils.generic.JsonStringHelper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DeletarMesaControllerTest {

  @Mock
  private DeletarMesaUseCase deletarMesaUseCase;

  private MockMvc mockMvc;

  AutoCloseable openMocks;

  @BeforeEach
  void setUp() {
    openMocks = MockitoAnnotations.openMocks(this);
    DeletarMesaController controller = new DeletarMesaController(deletarMesaUseCase);
    mockMvc = MockMvcBuilders.standaloneSetup(controller)
        .addFilter((request, response, chain) -> {
          response.setCharacterEncoding("UTF-8");
          chain.doFilter(request, response);
        })
        .setControllerAdvice(new GlobalExceptionHandler())
        .build();
  }

  @Test
  void devePermitirDeletarUsuario() throws Exception {
    Long id = 1L;

    when(deletarMesaUseCase.deletarMesa(any(Long.class))).thenReturn(true);

    mockMvc.perform(
        delete("/mesas/{id}", id)
        .content(JsonStringHelper.asJsonString(new MesaDeletadaResponse(true)))
        .contentType(MediaType.APPLICATION_JSON)
    )
        
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.deletado").value(true));

    verify(deletarMesaUseCase, times(1)).deletarMesa(any(Long.class));
  }

  @Test
  void deveGerarExcecao_QuandoDeletarMesa_IdDaMesaNaoExiste() throws Exception {
    Long id = 1L;

    when(deletarMesaUseCase.deletarMesa(any(Long.class))).thenThrow(new MesaNotFoundException("Mesa de id: " + id + " não encontrada"));

    mockMvc.perform(
        delete("/mesas/{id}", id)
        .contentType(MediaType.APPLICATION_JSON)
    )
        
        .andExpect(jsonPath("$.erro").value("Mesa de id: " + id + " não encontrada"))
        .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
        .andExpect(jsonPath("$.horario").exists())
        .andExpect(jsonPath("$.rota").value("/mesas/" + id));

    verify(deletarMesaUseCase, times(1)).deletarMesa(any(Long.class));
  }
}
