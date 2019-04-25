package org.academiadecodigo.charlie.converters;

import org.academiadecodigo.charlie.command.UserDto;
import org.academiadecodigo.charlie.persistence.model.User;
import org.academiadecodigo.charlie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter extends AbstractConverter<UserDto, User> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

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
