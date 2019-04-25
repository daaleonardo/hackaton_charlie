package org.academiadecodigo.charlie.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class User extends AbstractModel {

    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String email;
    private String biography;

    private List<Card> cards = new ArrayList<>();
}
