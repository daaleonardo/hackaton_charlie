package org.academiadecodigo.charlie.persistence.dao;

import org.academiadecodigo.charlie.persistence.model.User;

public interface UserDao extends Dao<User> {

    User findByEmail(String email);
}
