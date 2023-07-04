package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.GenericParagrafoDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericEstudoParagrafoDTO;
import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;
import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GenericParagrafoDtoBuilderImpl implements GenericParagrafoDtoBuilder {

    private GenericParagrafoDTO genericParagrafoDTO = new GenericParagrafoDTO();

    @Override
    public GenericParagrafoDtoBuilder id(String id) {
        this.genericParagrafoDTO.setId(id);
        return this;
    }

    @Override
    public GenericParagrafoDtoBuilder titulo(String titulo) {
        this.genericParagrafoDTO.setTitulo(titulo);
        return this;
    }

    @Override
    public GenericParagrafoDtoBuilder conteudo(String conteudo) {
        List<String> paragrafos = new ArrayList<>();
        if (conteudo != null) {
            paragrafos.addAll(Arrays.stream(conteudo.split("<br>")).toList());
        }
        this.genericParagrafoDTO.setConteudo(paragrafos);
        return this;
    }

    @Override
    public GenericParagrafoDtoBuilder sequencia(int sequencia) {
        this.genericParagrafoDTO.setSequencia(sequencia);
        return this;
    }

    @Override
    public GenericParagrafoDtoBuilder estudos(List<EstudoParagrafoEntity> estudosParagrafo) {
        if (estudosParagrafo != null) {
            List<GenericEstudoParagrafoDTO> estudos = estudosParagrafo
                    .stream()
                    .map(item -> new GenericEstudoParagrafoDtoBuilderImpl()
                            .id(item.getEstudo().getId().toString())
                            .titulo(item.getEstudo().getTitulo())
                            .conteudo(item.getEstudo().getConteudo())
                            .aprovado(item.getEstudo().isAprovado())
                            .nomeDoAutor(item.getEstudo().getNomeDoAutor())
                            .dataPublicacao(item.getEstudo().getDataPublicacao())
                            .build()
                    )
                    .sorted(new Comparator<GenericEstudoParagrafoDTO>() {
                        @Override
                        public int compare(GenericEstudoParagrafoDTO o1, GenericEstudoParagrafoDTO o2) {
                            return o1.getDataPublicacao().compareTo(o2.getDataPublicacao());
                        }
                    })
                    .toList();

            this.genericParagrafoDTO.setEstudos(estudos);
        }

        return this;
    }

    @Override
    public GenericParagrafoDTO build() {
        return this.genericParagrafoDTO;
    }

}
