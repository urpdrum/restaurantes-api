package com.fiap.restaurantes.infra.feign;

import com.fiap.restaurantes.domain.output.endereco.EnderecoResponse;
import com.fiap.restaurantes.infra.config.feign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ceps", primary = false, contextId = "enderecoClient", url = "${application.client.endereco.host}",
        configuration = FeignConfiguration.class)
public interface ConsultarEnderecoPorCepClient {

    /**
     * @param cep
     * @return
     */
    @GetMapping(value = "/{cep}/json/", consumes = MediaType.APPLICATION_JSON_VALUE)
    EnderecoResponse consultaPorCep(@PathVariable("cep") String cep);

}