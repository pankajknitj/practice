package main.lld.behavioral.strategy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDetails {
    private String cardNumber;
    private String cardHolder;
    private int cvv;
}
