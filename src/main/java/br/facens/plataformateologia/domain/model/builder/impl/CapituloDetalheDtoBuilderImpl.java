package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.CapituloDetalheDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.CapituloDetalheDTO;
import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;
import br.facens.plataformateologia.domain.model.entity.ParagrafoEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CapituloDetalheDtoBuilderImpl implements CapituloDetalheDtoBuilder {

    private CapituloDetalheDTO capituloDetalheDTO = new CapituloDetalheDTO();

    @Override
    public CapituloDetalheDtoBuilder capituloId(String capituloId) {
        this.capituloDetalheDTO.setCapituloId(capituloId);
        return this;
    }

    @Override
    public CapituloDetalheDtoBuilder materialId(String materialId) {
        this.capituloDetalheDTO.setMaterialId(materialId);
        return this;
    }

    @Override
    public CapituloDetalheDtoBuilder tituloMaterial(String tituloMaterial) {
        this.capituloDetalheDTO.setTituloMaterial(tituloMaterial);
        return this;
    }

    @Override
    public CapituloDetalheDtoBuilder tituloCapitulo(String tituloCapitulo) {
        this.capituloDetalheDTO.setTituloCapitulo(tituloCapitulo);
        return this;
    }

    @Override
    public CapituloDetalheDtoBuilder sequencia(int sequencia) {
        this.capituloDetalheDTO.setSequencia(sequencia);
        return this;
    }

    @Override
    public CapituloDetalheDtoBuilder paragrafos(List<ParagrafoEntity> paragrafos) {
        List<GenericParagrafoDTO> paragrafoDtos = paragrafos
                .stream()
                .map(item -> new GenericParagrafoDtoBuilderImpl()
                        .id(item.getId().toString())
                        .titulo(item.getTitulo())
                        .conteudo(item.getConteudo())
                        .sequencia(item.getSequencia())
                        .estudos(item.getEstudos())
                        .build()
                )
                .sorted(new Comparator<GenericParagrafoDTO>() {
                    @Override
                    public int compare(GenericParagrafoDTO o1, GenericParagrafoDTO o2) {
                        return o1.getSequencia() - o2.getSequencia();
                    }
                })
                .toList();

        this.capituloDetalheDTO.setParagrafos(paragrafoDtos);
        return this;
    }

    @Override
    public CapituloDetalheDTO build() {
        return this.capituloDetalheDTO;
    }
}
