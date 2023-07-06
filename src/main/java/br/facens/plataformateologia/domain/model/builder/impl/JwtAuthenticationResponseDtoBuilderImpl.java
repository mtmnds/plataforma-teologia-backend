package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.JwtAuthenticationResponseDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.JwtAuthenticationResponseDTO;

public class JwtAuthenticationResponseDtoBuilderImpl implements JwtAuthenticationResponseDtoBuilder {

    private JwtAuthenticationResponseDTO jwtAuthenticationResponseDTO = new JwtAuthenticationResponseDTO();

    @Override
    public JwtAuthenticationResponseDtoBuilder token(String token) {
        this.jwtAuthenticationResponseDTO.setToken(token);
        return this;
    }

    @Override
    public JwtAuthenticationResponseDTO build() {
        return this.jwtAuthenticationResponseDTO;
    }

}
