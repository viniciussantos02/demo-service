package com.example.demo.mapper;

import com.example.demo.domain.enums.PersonRole;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "username", source = "login")
    @Mapping(target = "password", source = "password", qualifiedByName = "encodeUserPassword")
    @Mapping(target = "personRole", source = "role", qualifiedByName = "getRoleId")
    User registerDTOToUser(RegisterDTO source);

    @Named("getRoleId")
    default int getRoleId(PersonRole role) {
        return role.getRoleId();
    }

    @Named("encodeUserPassword")
    default String encodeUserPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
