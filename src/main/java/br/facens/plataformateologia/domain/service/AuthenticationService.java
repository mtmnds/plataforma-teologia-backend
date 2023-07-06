package br.facens.plataformateologia.domain.service;

import br.facens.plataformateologia.domain.model.dto.JwtAuthenticationResponseDTO;
import br.facens.plataformateologia.domain.model.dto.SigninRequestDTO;
import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;

public interface AuthenticationService {
    JwtAuthenticationResponseDTO signup(SignupRequestDTO request);
    JwtAuthenticationResponseDTO signin(SigninRequestDTO request);
}
