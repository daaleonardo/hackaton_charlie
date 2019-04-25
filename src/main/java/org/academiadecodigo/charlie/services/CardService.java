package org.academiadecodigo.charlie.services;

import org.academiadecodigo.charlie.persistence.model.Card;
import org.springframework.stereotype.Service;

public interface CardService {

    Card get(Integer id);
}
