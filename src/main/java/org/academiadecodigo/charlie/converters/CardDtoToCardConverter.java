package org.academiadecodigo.charlie.converters;

import org.academiadecodigo.charlie.command.CardDto;
import org.academiadecodigo.charlie.persistence.model.Card;
import org.academiadecodigo.charlie.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardDtoToCardConverter extends AbstractConverter<CardDto, Card> {

    CardService cardService;

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public Card convert(CardDto cardDto) {

        // Card Service Missing - Don't Use
        Card card = (cardDto.getId() != null ? cardService.get(cardDto.getId()) : new Card());;

        card.setCardName(cardDto.getName());
        card.setDescription(cardDto.getDescription());

        return card;
    }
}
