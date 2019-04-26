package org.academiadecodigo.charlie.services;

import org.academiadecodigo.charlie.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterServiceImpl implements RegisterService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkEmail(String email) {

        return (userDao.findByEmail(email) != null);
    }
}
