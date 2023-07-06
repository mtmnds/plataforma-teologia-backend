package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupRequestDtoBuilderImplTest {

    @Test
    void builder() {
        SignupRequestDTO dto = new SignupRequestDtoBuilderImpl()
                .name("Name teste")
                .username("Username teste")
                .password("Password teste")
                .build();

        assertNotNull(dto);
        assertEquals(dto.getName(), "Name teste");
        assertEquals(dto.getUsername(), "Username teste");
        assertEquals(dto.getPassword(), "Password teste");
    }

}