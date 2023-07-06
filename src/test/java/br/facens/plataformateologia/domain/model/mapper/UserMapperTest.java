package br.facens.plataformateologia.domain.model.mapper;

import br.facens.plataformateologia.domain.model.dto.SignupRequestDTO;
import br.facens.plataformateologia.domain.model.entity.UserEntity;
import br.facens.plataformateologia.domain.model.enums.RoleEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void map() {
        SignupRequestDTO toMap = new SignupRequestDTO();
        toMap.setName("Name teste");
        toMap.setUsername("Username teste");
        toMap.setPassword("Password teste");

        UserMapper mapper = new UserMapper();
        UserEntity mapped = mapper.map(toMap);

        assertEquals(toMap.getName(), mapped.getName());
        assertEquals(toMap.getUsername(), mapped.getUsername());
        assertEquals(toMap.getPassword(), mapped.getPassword());
        assertEquals(mapped.getRole(), RoleEnum.USER);
    }

}