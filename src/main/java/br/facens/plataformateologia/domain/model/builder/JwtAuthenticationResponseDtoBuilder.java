package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.JwtAuthenticationResponseDTO;

public interface JwtAuthenticationResponseDtoBuilder {
    JwtAuthenticationResponseDtoBuilder token(String token);
    JwtAuthenticationResponseDTO build();
}
