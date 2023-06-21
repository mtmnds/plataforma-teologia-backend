package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.GenericCapituloDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericCapituloDTO;

public class GenericCapituloDtoBuilderImpl implements GenericCapituloDtoBuilder {
    private GenericCapituloDTO genericCapituloDTO = new GenericCapituloDTO();

    @Override
    public GenericCapituloDtoBuilder id(String id) {
        this.genericCapituloDTO.setId(id);
        return this;
    }

    @Override
    public GenericCapituloDtoBuilder titulo(String titulo) {
        this.genericCapituloDTO.setTitulo(titulo);
        return this;
    }

    @Override
    public GenericCapituloDtoBuilder sequencia(int sequencia) {
        this.genericCapituloDTO.setSequencia(sequencia);
        return this;
    }

    @Override
    public GenericCapituloDTO build() {
        return this.genericCapituloDTO;
    }
}
