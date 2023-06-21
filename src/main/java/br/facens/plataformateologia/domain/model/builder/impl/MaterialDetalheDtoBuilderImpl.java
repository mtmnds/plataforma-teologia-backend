package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.MaterialDetalheDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericCapituloDTO;
import br.facens.plataformateologia.domain.model.dto.MaterialDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.CapituloEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaterialDetalheDtoBuilderImpl implements MaterialDetalheDtoBuilder {

    private MaterialDetalheDTO materialDetalheDTO = new MaterialDetalheDTO();

    @Override
    public MaterialDetalheDtoBuilder id(String id) {
        this.materialDetalheDTO.setId(id);
        return this;
    }

    @Override
    public MaterialDetalheDtoBuilder titulo(String titulo) {
        this.materialDetalheDTO.setTitulo(titulo);
        return this;
    }

    @Override
    public MaterialDetalheDtoBuilder urlImagem(String urlImagem) {
        this.materialDetalheDTO.setUrlImagem(urlImagem);
        return this;
    }

    @Override
    public MaterialDetalheDtoBuilder descricao(String descricao) {
        List<String> paragrafos = new ArrayList<>();
        if (descricao != null) {
            paragrafos.addAll(Arrays.stream(descricao.split("<br>")).toList());
        }
        this.materialDetalheDTO.setDescricao(paragrafos);
        return this;
    }

    @Override
    public MaterialDetalheDtoBuilder capitulos(List<CapituloEntity> capitulos) {
        List<GenericCapituloDTO> capituloDtos = capitulos
                .stream()
                .map(item -> new GenericCapituloDtoBuilderImpl()
                        .id(item.getId().toString())
                        .titulo(item.getTitulo())
                        .sequencia(item.getSequencia())
                        .build()
                )
                .sorted(new Comparator<GenericCapituloDTO>() {
                    @Override
                    public int compare(GenericCapituloDTO o1, GenericCapituloDTO o2) {
                        return o1.getSequencia() - o2.getSequencia();
                    }
                })
                .toList();

        this.materialDetalheDTO.setCapitulos(capituloDtos);
        return this;
    }

    @Override
    public MaterialDetalheDTO build() {
        return this.materialDetalheDTO;
    }

}
