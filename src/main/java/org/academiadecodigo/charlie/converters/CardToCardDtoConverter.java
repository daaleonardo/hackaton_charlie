package org.academiadecodigo.charlie.converters;

import org.academiadecodigo.charlie.command.CardDto;
import org.academiadecodigo.charlie.persistence.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardToCardDtoConverter extends AbstractConverter<Card, CardDto> {

    @Override
    public CardDto convert(Card card) {

        // Card Service Missing - Don't Use
        CardDto cardDto = new CardDto();

        cardDto.setName(card.getName());
        cardDto.setDescription(card.getDescription());

        return cardDto;
    }
}
