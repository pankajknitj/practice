package main.lld.behavioral.chainofresponsibility.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Request {
    private String user;
    private String userRole;
    private int reqCount;
    private String payload;
}
