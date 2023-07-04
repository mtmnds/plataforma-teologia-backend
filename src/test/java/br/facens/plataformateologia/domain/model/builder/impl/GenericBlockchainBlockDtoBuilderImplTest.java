package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GenericBlockchainBlockDtoBuilderImplTest {

    @Test
    void builder() {
        Date dataTeste = new Date();

        GenericBlockchainBlockDTO dto = new GenericBlockchainBlockDtoBuilderImpl()
                .previousHash("Previous hash teste")
                .data("Block data teste")
                .timestamp(dataTeste.getTime())
                .nonce(7)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getPreviousHash(), "Previous hash teste");
        assertEquals(dto.getData(), "Block data teste");
        assertEquals(dto.getTimestamp(), dataTeste.getTime());
        assertEquals(dto.getNonce(), 7);
    }
}