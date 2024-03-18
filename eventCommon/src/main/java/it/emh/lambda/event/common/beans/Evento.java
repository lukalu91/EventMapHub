package it.emh.lambda.event.common.beans;

import it.emh.lambda.event.common.enums.EventType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Evento {

    private String nome;
    private String descrizione;
    private Luogo luogo;
    private Date data;
    private EventType tipo;
}
