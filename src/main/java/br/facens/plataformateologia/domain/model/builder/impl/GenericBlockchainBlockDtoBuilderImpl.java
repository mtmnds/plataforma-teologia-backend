package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.GenericBlockchainBlockDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;

public class GenericBlockchainBlockDtoBuilderImpl implements GenericBlockchainBlockDtoBuilder {

    private GenericBlockchainBlockDTO genericBlockchainBlockDTO = new GenericBlockchainBlockDTO();

    @Override
    public GenericBlockchainBlockDtoBuilder hash(String hash) {
        this.genericBlockchainBlockDTO.setHash(hash);
        return this;
    }

    @Override
    public GenericBlockchainBlockDtoBuilder previousHash(String previousHash) {
        this.genericBlockchainBlockDTO.setPreviousHash(previousHash);
        return this;
    }

    @Override
    public GenericBlockchainBlockDtoBuilder data(String data) {
        this.genericBlockchainBlockDTO.setData(data);
        return this;
    }

    @Override
    public GenericBlockchainBlockDtoBuilder timestamp(long timestamp) {
        this.genericBlockchainBlockDTO.setTimestamp(timestamp);
        return this;
    }

    @Override
    public GenericBlockchainBlockDtoBuilder nonce(int nonce) {
        this.genericBlockchainBlockDTO.setNonce(nonce);
        return this;
    }

    @Override
    public GenericBlockchainBlockDTO build() {
        return this.genericBlockchainBlockDTO;
    }

}
