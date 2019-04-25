package org.academiadecodigo.charlie.services;

import org.academiadecodigo.charlie.exceptions.UserNotFoundException;
import org.academiadecodigo.charlie.persistence.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    User save(User user);

    void delete(Integer id) throws UserNotFoundException;

    List<User> list();

}
