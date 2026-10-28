package main.lld.behavioral.template.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int orderId;
    private List<Item> items = new ArrayList<>();
}
