package main.lld.behavioral.chainofresponsibility.impl;

import lombok.Data;
import main.lld.behavioral.chainofresponsibility.face.BaseHandler;
import main.lld.behavioral.chainofresponsibility.model.Request;

//Authorization handler
public class Authzhandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getUserRole().equals("Admin")){
            System.out.println("Authorization Completed");
            forward(request);
        }else{
            System.out.println("Authorization denied");
        }
    }
}
