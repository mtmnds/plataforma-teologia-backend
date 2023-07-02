package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.GenericEstudoParagrafoDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericEstudoParagrafoDTO;

import java.util.Date;

public class GenericEstudoParagrafoDtoBuilderImpl implements GenericEstudoParagrafoDtoBuilder {

    private GenericEstudoParagrafoDTO genericEstudoParagrafoDTO = new GenericEstudoParagrafoDTO();

    @Override
    public GenericEstudoParagrafoDtoBuilder id(String id) {
        genericEstudoParagrafoDTO.setId(id);
        return this;
    }

    @Override
    public GenericEstudoParagrafoDtoBuilder titulo(String titulo) {
        genericEstudoParagrafoDTO.setTitulo(titulo);
        return this;
    }

    @Override
    public GenericEstudoParagrafoDtoBuilder conteudo(String conteudo) {
        genericEstudoParagrafoDTO.setConteudo(conteudo);
        return this;
    }

    @Override
    public GenericEstudoParagrafoDtoBuilder aprovado(boolean aprovado) {
        genericEstudoParagrafoDTO.setAprovado(aprovado);
        return this;
    }

    @Override
    public GenericEstudoParagrafoDtoBuilder dataPublicacao(Date dataPublicacao) {
        genericEstudoParagrafoDTO.setDataPublicacao(dataPublicacao);
        return this;
    }

    @Override
    public GenericEstudoParagrafoDTO build() {
        return this.genericEstudoParagrafoDTO;
    }

}
