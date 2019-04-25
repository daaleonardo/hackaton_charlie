package org.academiadecodigo.charlie.converters;

import org.academiadecodigo.charlie.command.UserDto;
import org.academiadecodigo.charlie.persistence.model.User;

@
public class UserDtoToUserConverter extends AbstractConverter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        // User Service Missing - Don't Use
        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());;

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBiography(userDto.getBiography());

        return user;
    }
}
