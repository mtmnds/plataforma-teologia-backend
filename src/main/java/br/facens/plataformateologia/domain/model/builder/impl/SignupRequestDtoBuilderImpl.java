package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.builder.SignupRequestDtoBuilder;
import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;

public class SignupRequestDtoBuilderImpl implements SignupRequestDtoBuilder {

    private SignupRequestDTO signupRequestDTO = new SignupRequestDTO();

    @Override
    public SignupRequestDtoBuilder username(String username) {
        this.signupRequestDTO.setUsername(username);
        return this;
    }

    @Override
    public SignupRequestDtoBuilder password(String password) {
        this.signupRequestDTO.setPassword(password);
        return this;
    }

    @Override
    public SignupRequestDtoBuilder name(String name) {
        this.signupRequestDTO.setName(name);
        return this;
    }

    @Override
    public SignupRequestDTO build() {
        return this.signupRequestDTO;
    }

}
