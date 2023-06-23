package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.GenericCapituloDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericCapituloDtoBuilderImplTest {

    @Test
    void builder() {
        GenericCapituloDTO dto = new GenericCapituloDtoBuilderImpl()
                .id("ID Teste")
                .titulo("Titulo teste")
                .sequencia(1)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getId(), "ID Teste");
        assertEquals(dto.getTitulo(), "Titulo teste");
        assertEquals(dto.getSequencia(), 1);
    }

}