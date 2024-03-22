package it.emh.lambda.event.db.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LudoPointEntity {

    private int id;
    private int userid;
    private String nome;

    private String logintudine;
    private String latitudine;
}
