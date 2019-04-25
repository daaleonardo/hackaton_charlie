package org.academiadecodigo.charlie.persistence.dao.jpa;

import org.academiadecodigo.charlie.persistence.dao.CardDao;
import org.academiadecodigo.charlie.persistence.model.Card;

public class JpaCardDao extends GenericDao<Card> implements CardDao {

    public JpaCardDao(Class<Card> modelType) {
        super(modelType);
    }
}
