package br.facens.plataformateologia.domain.service;

import br.facens.plataformateologia.domain.model.dto.EstudoBlockchainDTO;
import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;
import br.facens.plataformateologia.domain.model.entity.EstudoEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.security.NoSuchAlgorithmException;

public interface BlockchainService {
    String addBlock(EstudoBlockchainDTO estudoBlockchainDTO) throws JsonProcessingException, NoSuchAlgorithmException;
}
