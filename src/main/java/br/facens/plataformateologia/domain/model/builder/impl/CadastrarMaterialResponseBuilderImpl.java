package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.CadastrarMaterialResponseBuilder;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialResponseDTO;

public class CadastrarMaterialResponseBuilderImpl implements CadastrarMaterialResponseBuilder {

    private CadastrarMaterialResponseDTO cadastrarMaterialResponseDTO = new CadastrarMaterialResponseDTO();

    @Override
    public CadastrarMaterialResponseBuilder id(String id) {
        this.cadastrarMaterialResponseDTO.setId(id);
        return this;
    }

    @Override
    public CadastrarMaterialResponseDTO build() {
        return this.cadastrarMaterialResponseDTO;
    }

}
