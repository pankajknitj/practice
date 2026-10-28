package main.lld.behavioral.chainofresponsibility.impl;

import main.lld.behavioral.chainofresponsibility.face.BaseHandler;
import main.lld.behavioral.chainofresponsibility.model.Request;

public class BussinessLogicHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("Reached Business Logic");
    }
}
