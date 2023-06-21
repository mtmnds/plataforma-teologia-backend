package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialResponseDTO;

public interface CadastrarMaterialResponseBuilder {
    CadastrarMaterialResponseBuilder id(String id);
    CadastrarMaterialResponseDTO build();
}
