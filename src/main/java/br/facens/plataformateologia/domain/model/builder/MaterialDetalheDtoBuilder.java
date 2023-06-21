package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericCapituloDTO;
import br.facens.plataformateologia.domain.model.dto.MaterialDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.CapituloEntity;

import java.util.List;

public interface MaterialDetalheDtoBuilder {
    MaterialDetalheDtoBuilder id(String id);
    MaterialDetalheDtoBuilder titulo(String titulo);
    MaterialDetalheDtoBuilder urlImagem(String urlImagem);
    MaterialDetalheDtoBuilder descricao(String descricao);
    MaterialDetalheDtoBuilder capitulos(List<CapituloEntity> capitulos);
    MaterialDetalheDTO build();
}
