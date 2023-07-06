package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;

public interface SignupRequestDtoBuilder {
    SignupRequestDtoBuilder username(String username);
    SignupRequestDtoBuilder password(String password);
    SignupRequestDtoBuilder name(String name);
    SignupRequestDTO build();
}
