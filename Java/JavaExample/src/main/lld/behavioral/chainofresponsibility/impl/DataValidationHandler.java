package main.lld.behavioral.chainofresponsibility.impl;

import main.lld.behavioral.chainofresponsibility.face.BaseHandler;
import main.lld.behavioral.chainofresponsibility.model.Request;

public class DataValidationHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getPayload() != null){
            System.out.println("Data Validation Successful");
            forward(request);
        }else{
            System.out.println("Data validation failed");
        }
    }
}
