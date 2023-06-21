package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.CapituloDetalheDTO;
import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;
import br.facens.plataformateologia.domain.model.entity.ParagrafoEntity;

import java.util.List;

public interface CapituloDetalheDtoBuilder {
    CapituloDetalheDtoBuilder capituloId(String capituloId);
    CapituloDetalheDtoBuilder materialId(String materialId);
    CapituloDetalheDtoBuilder tituloMaterial(String tituloMaterial);
    CapituloDetalheDtoBuilder tituloCapitulo(String tituloCapitulo);
    CapituloDetalheDtoBuilder sequencia(int sequencia);
    CapituloDetalheDtoBuilder paragrafos(List<ParagrafoEntity> paragrafos);
    CapituloDetalheDTO build();
}
