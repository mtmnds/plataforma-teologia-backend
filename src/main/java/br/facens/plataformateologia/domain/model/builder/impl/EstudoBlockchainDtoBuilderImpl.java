package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.EstudoBlockchainDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.EstudoBlockchainDTO;

import java.util.Date;

public class EstudoBlockchainDtoBuilderImpl implements EstudoBlockchainDtoBuilder {

    private EstudoBlockchainDTO estudoBlockchainDTO = new EstudoBlockchainDTO();

    @Override
    public EstudoBlockchainDtoBuilder id(String id) {
        this.estudoBlockchainDTO.setId(id);
        return this;
    }

    @Override
    public EstudoBlockchainDtoBuilder titulo(String titulo) {
        this.estudoBlockchainDTO.setTitulo(titulo);
        return this;
    }

    @Override
    public EstudoBlockchainDtoBuilder conteudo(String conteudo) {
        this.estudoBlockchainDTO.setConteudo(conteudo);
        return this;
    }

    @Override
    public EstudoBlockchainDtoBuilder dataPublicacao(Date dataPublicacao) {
        this.estudoBlockchainDTO.setDataPublicacao(dataPublicacao);
        return this;
    }

    @Override
    public EstudoBlockchainDTO build() {
        return this.estudoBlockchainDTO;
    }

}
