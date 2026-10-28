package main.lld.behavioral.chainofresponsibility.impl;

import main.lld.behavioral.chainofresponsibility.face.BaseHandler;
import main.lld.behavioral.chainofresponsibility.model.Request;

//authentication Handler
public class AuthHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getUser() != null){
            System.out.println("Auth completed");
            forward(request);
        }else{
            System.out.println("Auth Denied");
        }
    }
}
