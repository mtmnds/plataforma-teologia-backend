package br.facens.plataformateologia.application.controller;

import br.facens.plataformateologia.domain.model.dto.JwtAuthenticationResponseDTO;
import br.facens.plataformateologia.domain.model.dto.SigninRequestDTO;
import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;
import br.facens.plataformateologia.domain.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("auth")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(
            AuthenticationService authenticationService
    ) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(
            value = "signup",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<JwtAuthenticationResponseDTO> signup(
            @RequestBody SignupRequestDTO signupRequestDTO
    ) {
        try {
            return ResponseEntity.ok(this.authenticationService.signup(signupRequestDTO));
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(
            value = {"", "/"},
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<JwtAuthenticationResponseDTO> signin(
            @RequestBody SigninRequestDTO signinRequestDTO
    ) {
        try {
            return ResponseEntity.ok(this.authenticationService.signin(signinRequestDTO));
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
