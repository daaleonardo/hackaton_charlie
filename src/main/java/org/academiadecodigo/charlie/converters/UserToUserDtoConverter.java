package org.academiadecodigo.charlie.converters;

import org.academiadecodigo.charlie.command.UserDto;
import org.academiadecodigo.charlie.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter extends AbstractConverter<User, UserDto> {

    @Override
    public UserDto convert(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword().toString());
        userDto.setBiography(user.getBiography());

        return userDto;
    }
}
