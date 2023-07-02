package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;
import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;

import java.util.List;

public interface GenericParagrafoDtoBuilder {
    GenericParagrafoDtoBuilder id(String id);
    GenericParagrafoDtoBuilder titulo(String titulo);
    GenericParagrafoDtoBuilder conteudo(String conteudo);
    GenericParagrafoDtoBuilder estudos(List<EstudoParagrafoEntity> estudosParagrafo);
    GenericParagrafoDtoBuilder sequencia(int sequencia);
    GenericParagrafoDTO build();
}
