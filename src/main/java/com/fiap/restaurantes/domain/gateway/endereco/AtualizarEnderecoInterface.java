package com.fiap.restaurantes.domain.gateway.endereco;

import com.fiap.restaurantes.domain.entity.Endereco;
import com.fiap.restaurantes.domain.entity.Mesa;

public interface AtualizarEnderecoInterface {
    Mesa atualizarEndereco(Endereco endereco);
}
