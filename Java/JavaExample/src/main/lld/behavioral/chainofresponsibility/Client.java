package main.lld.behavioral.chainofresponsibility;

import main.lld.behavioral.chainofresponsibility.face.RequestHandler;
import main.lld.behavioral.chainofresponsibility.impl.*;
import main.lld.behavioral.chainofresponsibility.model.Request;

public class Client {
    public static void main(String[] args) {
        //Handlers
        RequestHandler authHandler = new AuthHandler();
        RequestHandler authzHandler = new Authzhandler();
        RequestHandler rateLimitHandler = new RateLimitingHandler();
        RequestHandler dataValidationHandler = new DataValidationHandler();
        RequestHandler bussLogicHandler = new BussinessLogicHandler();

        //Handlers chain building
        authHandler.setNextHandler(authzHandler);
        authzHandler.setNextHandler(rateLimitHandler);
        rateLimitHandler.setNextHandler(dataValidationHandler);
        dataValidationHandler.setNextHandler(bussLogicHandler);

        Request request1 = new Request("pankaj","Admin",4,"knok knok");
        //invoking first member of chain
        authHandler.handle(request1);
    }

}
