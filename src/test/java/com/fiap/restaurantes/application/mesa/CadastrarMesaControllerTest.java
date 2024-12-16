package com.fiap.restaurantes.application.mesa;

import com.fiap.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.restaurantes.domain.entity.Mesa;
import com.fiap.restaurantes.domain.input.mesa.CadastrarMesaRequest;
import com.fiap.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.restaurantes.domain.usecase.mesa.CadastrarMesaUseCase;
import com.fiap.restaurantes.utils.generic.JsonStringHelper;
import com.fiap.restaurantes.utils.mesa.MesaHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CadastrarMesaControllerTest {
  @Mock
  private CadastrarMesaUseCase cadastrarMesaUseCase;

  @Mock
  private MesaMapper mapper;

  MockMvc mockMvc;

  AutoCloseable openMocks;

  @BeforeEach
  void setUp() {
    openMocks = MockitoAnnotations.openMocks(this);
    CadastrarMesaController controller = new CadastrarMesaController(mapper, cadastrarMesaUseCase);
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
  void devePermitirCadastrarMesa() throws Exception {
    Long restauranteId = 1L;
    Integer quantidadeAssentos = 4;

    Mesa mesa = MesaHelper.gerarMesa();
    mesa.setMesaId(1L);
    mesa.getRestaurante().setRestauranteId(restauranteId);
    mesa.setQuantidadeAssentos(quantidadeAssentos);

    CadastrarMesaRequest request = MesaHelper.gerarMesaCadastroRequest(restauranteId, quantidadeAssentos);

    MesaResponse response = MesaHelper.gerarMesaResponse(mesa);

    when(mapper.toMesa(any(CadastrarMesaRequest.class))).thenReturn(mesa);
    when(cadastrarMesaUseCase.cadastrarMesa(any(Mesa.class))).thenAnswer(answer -> answer.getArgument(0));
    when(mapper.toMesaResponse(any(Mesa.class))).thenReturn(response);

    System.out.println(response.id());
    URI uri = URI.create("http://localhost/mesas/" + response.id());
    System.out.println(uri);

    mockMvc.perform(
        post("/mesas")
            .content(JsonStringHelper.asJsonString(request))
            .contentType(MediaType.APPLICATION_JSON)
    )
        
        .andExpect(status().isCreated())
        .andExpect(header().string("Location", uri.toString()))
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.restauranteId").value(restauranteId))
        .andExpect(jsonPath("$.capacidade").value(quantidadeAssentos));

    verify(mapper, times(1)).toMesa(any(CadastrarMesaRequest.class));
    verify(mapper, times(1)).toMesaResponse(any(Mesa.class));
    verify(cadastrarMesaUseCase, times(1)).cadastrarMesa(any(Mesa.class));
  }
}
