package main.lld.behavioral.chainofresponsibility.impl;

import main.lld.behavioral.chainofresponsibility.face.BaseHandler;
import main.lld.behavioral.chainofresponsibility.model.Request;

public class RateLimitingHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getReqCount()>5){
            System.out.println("Too Many Request, canceling request");
        }else{
            forward(request);
        }
    }
}
