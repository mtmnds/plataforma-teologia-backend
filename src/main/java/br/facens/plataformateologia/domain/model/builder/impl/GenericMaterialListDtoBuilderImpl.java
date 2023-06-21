package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.GenericMaterialListDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericMaterialListDTO;

public class GenericMaterialListDtoBuilderImpl implements GenericMaterialListDtoBuilder {
    private GenericMaterialListDTO genericMaterialListDto = new GenericMaterialListDTO();

    @Override
    public GenericMaterialListDtoBuilderImpl id(String id) {
        this.genericMaterialListDto.setId(id);
        return this;
    }

    @Override
    public GenericMaterialListDtoBuilderImpl titulo(String titulo) {
        this.genericMaterialListDto.setTitulo(titulo);
        return this;
    }

    @Override
    public GenericMaterialListDtoBuilderImpl descricao(String descricao) {
        this.genericMaterialListDto.setDescricao(descricao);
        return this;
    }

    @Override
    public GenericMaterialListDtoBuilderImpl urlImagem(String urlImagem) {
        this.genericMaterialListDto.setUrlImagem(urlImagem);
        return this;
    }

    @Override
    public GenericMaterialListDtoBuilder numPagina(int numPagina) {
        this.genericMaterialListDto.setNumPagina(numPagina);
        return this;
    }

    @Override
    public GenericMaterialListDtoBuilder qtdRegistros(int qtdRegistros) {
        this.genericMaterialListDto.setQtdRegistros(qtdRegistros);
        return this;
    }

    @Override
    public GenericMaterialListDTO build() {
        return this.genericMaterialListDto;
    }
}
