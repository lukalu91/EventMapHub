package it.emh.lambda.event.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {

    private String id;
    private String nome;
    private String cognome;

    private String password;
    private boolean twofa;

}
