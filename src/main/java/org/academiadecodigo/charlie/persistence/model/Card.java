package org.academiadecodigo.charlie.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card extends AbstractModel {

    private String cardName;
    private String description;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
