package org.academiadecodigo.charlie.persistence.dao.jpa;

import org.academiadecodigo.charlie.persistence.dao.UserDao;
import org.academiadecodigo.charlie.persistence.model.User;

public class JpaUserDao extends GenericDao<User> implements UserDao {

    public JpaUserDao(Class<User> modelType) {
        super(modelType);
    }
}
