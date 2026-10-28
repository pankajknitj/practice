package main.lld.behavioral.chainofresponsibility.face;

import main.lld.behavioral.chainofresponsibility.model.Request;

//Handler Contract
public interface RequestHandler {
    void setNextHandler(RequestHandler handler);
    void handle(Request request);
}
