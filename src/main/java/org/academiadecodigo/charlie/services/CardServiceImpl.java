package org.academiadecodigo.charlie.services;

import org.academiadecodigo.charlie.persistence.dao.CardDao;
import org.academiadecodigo.charlie.persistence.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private CardDao cardDao;

    @Autowired
    public void setCardDao(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public Card get(Integer id) {
        return cardDao.findById(id);
    }
}
