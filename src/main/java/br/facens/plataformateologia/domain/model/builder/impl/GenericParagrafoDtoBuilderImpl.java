package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.GenericParagrafoDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.GenericCapituloDTO;
import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;

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
    public GenericParagrafoDTO build() {
        return this.genericParagrafoDTO;
    }

}
