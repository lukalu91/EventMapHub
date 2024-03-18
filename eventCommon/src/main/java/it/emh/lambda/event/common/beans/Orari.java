package it.emh.lambda.event.common.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Orari {
    private String lun;
    private String mar;
    private String mer;
    private String gio;
    private String ven;
    private String sab;
    private String dom;
}
