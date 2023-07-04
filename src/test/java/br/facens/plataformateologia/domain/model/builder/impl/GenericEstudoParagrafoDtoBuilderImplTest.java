package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.GenericEstudoParagrafoDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GenericEstudoParagrafoDtoBuilderImplTest {

    @Test
    void builder() {
        Date dataTeste = new Date();

        GenericEstudoParagrafoDTO dto = new GenericEstudoParagrafoDtoBuilderImpl()
                .id("ID Teste")
                .titulo("Titulo teste")
                .conteudo("Conteudo teste")
                .aprovado(true)
                .dataPublicacao(dataTeste)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getId(), "ID Teste");
        assertEquals(dto.getTitulo(), "Titulo teste");
        assertEquals(dto.getConteudo(), "Conteudo teste");
        assertTrue(dto.isAprovado());
        assertEquals(dto.getDataPublicacao(), dataTeste);
    }

}