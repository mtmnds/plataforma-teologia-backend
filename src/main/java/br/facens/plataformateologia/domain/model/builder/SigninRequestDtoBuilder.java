package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.SigninRequestDTO;

public interface SigninRequestDtoBuilder {
    SigninRequestDtoBuilder username(String username);
    SigninRequestDtoBuilder password(String password);
    SigninRequestDTO build();
}
