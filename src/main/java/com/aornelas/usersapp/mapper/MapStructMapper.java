package com.aornelas.usersapp.mapper;

import com.aornelas.usersapp.domain.User;
import com.aornelas.usersapp.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    UserDto userToUserDto(User user);
}
