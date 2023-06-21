package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericCapituloDTO;

public interface GenericCapituloDtoBuilder {
    GenericCapituloDtoBuilder id(String id);
    GenericCapituloDtoBuilder titulo(String titulo);
    GenericCapituloDtoBuilder sequencia(int sequencia);
    GenericCapituloDTO build();
}
