package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;

public interface GenericParagrafoDtoBuilder {
    GenericParagrafoDtoBuilder id(String id);
    GenericParagrafoDtoBuilder titulo(String titulo);
    GenericParagrafoDtoBuilder conteudo(String conteudo);
    GenericParagrafoDtoBuilder sequencia(int sequencia);
    GenericParagrafoDTO build();
}
