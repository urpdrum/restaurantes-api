package com.fiap.restaurantes.infra.adapter.endereco;

import com.fiap.restaurantes.domain.entity.Endereco;
import com.fiap.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import com.fiap.restaurantes.domain.mapper.endereco.EnderecoResponseMapper;
import com.fiap.restaurantes.infra.feign.ConsultarEnderecoPorCepClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class ConsultarEnderecoPorCepAdapter implements ConsultarEnderecoPorCepInterface {

    private final ConsultarEnderecoPorCepClient consultarEnderecoPorCepClient;

    private final EnderecoResponseMapper enderecoResponseMapper;

    @Override
    public Endereco consultaPorCep(String cep) {
        var enderecoResponse = consultarEnderecoPorCepClient.consultaPorCep(cep);
        return enderecoResponseMapper.toEndereco(enderecoResponse);
    }

}
