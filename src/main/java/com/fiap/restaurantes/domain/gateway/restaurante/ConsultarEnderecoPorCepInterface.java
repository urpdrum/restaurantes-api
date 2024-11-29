package com.fiap.restaurantes.domain.gateway.restaurante;

import com.fiap.restaurantes.domain.entity.Endereco;

public interface ConsultarEnderecoPorCepInterface {

    /**
     * @param cep
     * @return
     */
    Endereco consultaPorCep(final String cep);

}
