package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.EstudoBlockchainDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EstudoBlockchainDtoBuilderImplTest {

    @Test
    void builder() {
        Date dataTeste = new Date();

        EstudoBlockchainDTO dto = new EstudoBlockchainDtoBuilderImpl()
                .id("ID Teste")
                .titulo("Titulo teste")
                .conteudo("Conteudo teste")
                .dataPublicacao(dataTeste)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getId(), "ID Teste");
        assertEquals(dto.getTitulo(), "Titulo teste");
        assertEquals(dto.getConteudo(), "Conteudo teste");
        assertEquals(dto.getDataPublicacao(), dataTeste);
    }
}