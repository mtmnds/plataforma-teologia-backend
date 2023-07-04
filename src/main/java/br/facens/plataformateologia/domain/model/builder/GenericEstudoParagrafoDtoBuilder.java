package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericEstudoParagrafoDTO;

import java.util.Date;

public interface GenericEstudoParagrafoDtoBuilder {
    GenericEstudoParagrafoDtoBuilder id(String id);
    GenericEstudoParagrafoDtoBuilder titulo(String titulo);
    GenericEstudoParagrafoDtoBuilder conteudo(String conteudo);
    GenericEstudoParagrafoDtoBuilder aprovado(boolean aprovado);
    GenericEstudoParagrafoDtoBuilder nomeDoAutor(String nomeDoAutor);
    GenericEstudoParagrafoDtoBuilder dataPublicacao(Date dataPublicacao);
    GenericEstudoParagrafoDTO build();
}
