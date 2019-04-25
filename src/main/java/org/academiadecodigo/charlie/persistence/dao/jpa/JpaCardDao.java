package org.academiadecodigo.charlie.persistence.dao.jpa;

import org.academiadecodigo.charlie.persistence.dao.CardDao;
import org.academiadecodigo.charlie.persistence.model.Card;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCardDao extends GenericDao<Card> implements CardDao {

    public JpaCardDao() {
        super(Card.class);
    }
}
