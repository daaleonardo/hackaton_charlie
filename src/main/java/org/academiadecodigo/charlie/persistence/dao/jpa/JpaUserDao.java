package org.academiadecodigo.charlie.persistence.dao.jpa;

import org.academiadecodigo.charlie.persistence.dao.UserDao;
import org.academiadecodigo.charlie.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends GenericDao<User> implements UserDao {

    public JpaUserDao() {
        super(User.class);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
