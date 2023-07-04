package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;

public interface GenericBlockchainBlockDtoBuilder {
    GenericBlockchainBlockDtoBuilder hash(String hash);
    GenericBlockchainBlockDtoBuilder previousHash(String previousHash);
    GenericBlockchainBlockDtoBuilder data(String data);
    GenericBlockchainBlockDtoBuilder timestamp(long timestamp);
    GenericBlockchainBlockDtoBuilder nonce(int nonce);
    GenericBlockchainBlockDTO build();
}
