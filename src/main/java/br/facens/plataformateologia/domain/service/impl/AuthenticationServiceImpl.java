package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.builder.impl.JwtAuthenticationResponseDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.dto.JwtAuthenticationResponseDTO;
import br.facens.plataformateologia.domain.model.dto.SigninRequestDTO;
import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;
import br.facens.plataformateologia.domain.model.entity.UserEntity;
import br.facens.plataformateologia.domain.model.mapper.UserMapper;
import br.facens.plataformateologia.domain.repository.UserRepository;
import br.facens.plataformateologia.domain.service.AuthenticationService;
import br.facens.plataformateologia.domain.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
    private UserMapper userMapper;

    @Autowired
    public AuthenticationServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

    @Override
    public JwtAuthenticationResponseDTO signup(SignupRequestDTO request) {
        request.setPassword(this.passwordEncoder.encode(request.getPassword()));
        UserEntity user = this.userMapper.map(request);
        this.userRepository.save(user);

        String jwt = this.jwtService.generateToken(user);

        return new JwtAuthenticationResponseDtoBuilderImpl()
                .token(jwt)
                .build();
    }

    @Override
    public JwtAuthenticationResponseDTO signin(SigninRequestDTO request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserEntity user = this.userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Usuário ou senha inválidos."));

        String jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDtoBuilderImpl()
                .token(jwt)
                .build();
    }

}
