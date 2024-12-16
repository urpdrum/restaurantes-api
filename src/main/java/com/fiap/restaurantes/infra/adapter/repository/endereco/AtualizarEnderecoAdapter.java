//package com.fiap.restaurantes.infra.adapter.repository.endereco;
//
//import com.fiap.restaurantes.domain.entity.Endereco;
//import com.fiap.restaurantes.domain.entity.Mesa;
//import com.fiap.restaurantes.domain.gateway.endereco.AtualizarEnderecoInterface;
//import com.fiap.restaurantes.infra.entity.EnderecoEntity;
//import com.fiap.restaurantes.infra.repository.EnderecoRepository;
//import com.fiap.restaurantes.infra.repository.mapper.EnderecoEntityMapper;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//@Component
//@RequiredArgsConstructor
//public class AtualizarEnderecoAdapter implements AtualizarEnderecoInterface {
//
//
//
//        private final EnderecoRepository enderecoRepository;
//        private final EnderecoEntityMapper enderecoEntityMapper;
//
//        @Transactional
//        @Override
//        public Mesa atualizarEndereco(Endereco endereco) {
//            EnderecoEntity enderecoEntity = enderecoEntityMapper.toEnderecoEntity(endereco);
//
//            return enderecoEntityMapper.toEndereco(enderecoRepository.save(enderecoEntity));
//        }
//    }
//
