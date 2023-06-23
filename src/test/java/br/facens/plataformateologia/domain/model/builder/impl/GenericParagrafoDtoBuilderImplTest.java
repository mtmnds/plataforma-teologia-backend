package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.GenericParagrafoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericParagrafoDtoBuilderImplTest {

    @Test
    void builder() {
        GenericParagrafoDTO dto = new GenericParagrafoDtoBuilderImpl()
                .id("ID Teste")
                .titulo("Titulo teste")
                .conteudo("Linha 1<br>Linha 2<br>Linha 3")
                .sequencia(1)
                .build();

        assertNotNull(dto);
        assertNotNull(dto.getConteudo());
        assertEquals(dto.getConteudo().size(), 3);
        assertEquals(dto.getConteudo().get(0), "Linha 1");
        assertEquals(dto.getConteudo().get(1), "Linha 2");
        assertEquals(dto.getConteudo().get(2), "Linha 3");
    }
}