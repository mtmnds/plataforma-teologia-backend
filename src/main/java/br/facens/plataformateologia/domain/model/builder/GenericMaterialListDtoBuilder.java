package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericMaterialListDTO;

public interface GenericMaterialListDtoBuilder {
    GenericMaterialListDtoBuilder id(String id);
    GenericMaterialListDtoBuilder titulo(String titulo);
    GenericMaterialListDtoBuilder descricao(String descricao);
    GenericMaterialListDtoBuilder urlImagem(String urlImagem);
    GenericMaterialListDtoBuilder numPagina(int numPagina);
    GenericMaterialListDtoBuilder qtdRegistros(int qtdRegistros);
    GenericMaterialListDTO build();
}
