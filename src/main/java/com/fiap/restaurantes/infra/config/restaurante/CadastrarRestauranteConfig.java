package com.fiap.restaurantes.infra.config.restaurante;

import com.fiap.restaurantes.domain.gateway.restaurante.CadastrarRestauranteInterface;
import com.fiap.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import com.fiap.restaurantes.domain.usecase.restaurante.CadastrarRestauranteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarRestauranteConfig {

    /**
     * @param cadastrarRestauranteInterface
     * @param consultarEnderecoPorCepInterface
     * @return
     */
    @Bean
    public CadastrarRestauranteUseCase cadastrarRestauranteUseCase(CadastrarRestauranteInterface cadastrarRestauranteInterface,
                                                                   ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface) {
        return new CadastrarRestauranteUseCase(cadastrarRestauranteInterface, consultarEnderecoPorCepInterface);
    }
}
