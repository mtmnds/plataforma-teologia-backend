package br.facens.plataformateologia.domain.model.mapper;

import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;
import br.facens.plataformateologia.domain.model.entity.UserEntity;
import br.facens.plataformateologia.domain.model.enums.RoleEnum;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity map(SignupRequestDTO signupRequestDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(signupRequestDTO.getName());
        userEntity.setUsername(signupRequestDTO.getUsername());
        userEntity.setPassword(signupRequestDTO.getPassword());
        userEntity.setRole(RoleEnum.USER);

        return userEntity;
    }

}
