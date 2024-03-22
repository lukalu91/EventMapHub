package it.emh.lambda.event.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TavoloEntity {

    private int id;
    private int ludoid;
    private int posti;
    private String descrizione;

}
