package it.emh.lambda.event.common.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Luogo {
    private BigDecimal longitudine;
    private BigDecimal latitudine;
}
