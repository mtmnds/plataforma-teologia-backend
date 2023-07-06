package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.SigninRequestDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SigninRequestDtoBuilderImplTest {

    @Test
    void builder() {
        SigninRequestDTO dto = new SigninRequestDtoBuilderImpl()
                .username("Username teste")
                .password("Password teste")
                .build();

        assertNotNull(dto);
        assertEquals(dto.getUsername(), "Username teste");
        assertEquals(dto.getPassword(), "Password teste");
    }

}