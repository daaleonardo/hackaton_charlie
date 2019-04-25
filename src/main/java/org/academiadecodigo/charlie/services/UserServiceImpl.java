package org.academiadecodigo.charlie.services;

import org.academiadecodigo.charlie.command.UserLoginForm;
import org.academiadecodigo.charlie.exceptions.UserNotFoundException;
import org.academiadecodigo.charlie.persistence.dao.CardDao;
import org.academiadecodigo.charlie.persistence.dao.UserDao;
import org.academiadecodigo.charlie.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private CardDao cardDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setCardDao(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Transactional
    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws UserNotFoundException {

        User user = get(id);

        if (user == null) {
            throw new UserNotFoundException();
        }

        userDao.delete(id);

    }

    @Transactional
    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public boolean userExist(UserLoginForm userLoginForm) {

       User user = userDao.findByEmail(userLoginForm.getEmail());

       if(user == null){
           return false;
       }

       return (userLoginForm.getPassword().equals(user.getPassword()));
    }

}
