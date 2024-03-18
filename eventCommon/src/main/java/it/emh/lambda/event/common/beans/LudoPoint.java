package it.emh.lambda.event.common.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LudoPoint {
    private Luogo luogo;
    private Orari orari;
    private Regole regole;
    private List<Evento> events;
    private List<Tavolo> tavoli;
}
