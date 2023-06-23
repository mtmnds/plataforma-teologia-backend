package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.GenericMaterialListDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericMaterialListDtoBuilderImplTest {

    @Test
    void builder() {
        GenericMaterialListDTO dto = new GenericMaterialListDtoBuilderImpl()
                .id("ID Teste")
                .titulo("Titulo teste")
                .descricao("Descrição teste")
                .urlImagem("URL teste")
                .numPagina(1)
                .qtdRegistros(6)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getId(), "ID Teste");
        assertEquals(dto.getTitulo(), "Titulo teste");
        assertEquals(dto.getDescricao(), "Descrição teste");
        assertEquals(dto.getUrlImagem(), "URL teste");
        assertEquals(dto.getNumPagina(), 1);
        assertEquals(dto.getQtdRegistros(), 6);
    }

}