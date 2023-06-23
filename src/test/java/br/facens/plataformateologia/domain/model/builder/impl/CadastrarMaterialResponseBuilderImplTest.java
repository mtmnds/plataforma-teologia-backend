package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CadastrarMaterialResponseBuilderImplTest {

    @Test
    void builder() {
        CadastrarMaterialResponseDTO dto = new CadastrarMaterialResponseBuilderImpl()
                .id("ID Teste")
                .build();

        assertNotNull(dto);
        assertEquals(dto.getId(), "ID Teste");
    }

}