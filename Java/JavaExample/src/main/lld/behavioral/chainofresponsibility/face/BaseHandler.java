package main.lld.behavioral.chainofresponsibility.face;

import main.lld.behavioral.chainofresponsibility.model.Request;
//Base handler have common methods to avoid duplication
public abstract class BaseHandler implements RequestHandler{
    private RequestHandler nextHandler;

    @Override
    public void setNextHandler(RequestHandler handler){
        this.nextHandler = handler;
    }

    public void forward(Request request){
        if(nextHandler != null){
            System.out.println("forwarding request to next handler");
            nextHandler.handle(request);
        }
    }
}
