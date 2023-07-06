package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.JwtAuthenticationResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtAuthenticationResponseDtoBuilderImplTest {

    @Test
    void builder() {
        JwtAuthenticationResponseDTO dto = new JwtAuthenticationResponseDtoBuilderImpl()
                .token("Token teste")
                .build();

        assertNotNull(dto);
        assertEquals(dto.getToken(), "Token teste");
    }

}