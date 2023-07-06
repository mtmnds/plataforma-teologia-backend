package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.SigninRequestDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.SigninRequestDTO;

public class SigninRequestDtoBuilderImpl implements SigninRequestDtoBuilder {

    private SigninRequestDTO signinRequestDTO = new SigninRequestDTO();

    @Override
    public SigninRequestDtoBuilder username(String username) {
        this.signinRequestDTO.setUsername(username);
        return this;
    }

    @Override
    public SigninRequestDtoBuilder password(String password) {
        this.signinRequestDTO.setPassword(password);
        return this;
    }

    @Override
    public SigninRequestDTO build() {
        return this.signinRequestDTO;
    }

}
