package com.aornelas.usersapp.mapper;

import com.aornelas.usersapp.domain.User;
import com.aornelas.usersapp.dto.UserDto;
import org.springframework.stereotype.Component;


@Component
public class MapStructMapperImpl implements MapStructMapper{
    @Override
    public UserDto userToUserDto(User user) {
        if (user == null){
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setDob(user.getDob().toString());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
