package main.lld.behavioral.mediator.impl;

import main.lld.behavioral.mediator.face.UIComponent;
import main.lld.behavioral.mediator.face.UIMediator;

public class Button extends UIComponent {
    private boolean enabled = false;
    public Button(UIMediator mediator) {
        super(mediator);
    }
    public void setEnabled(boolean flag){
        enabled = flag;
        notifyMediator();
    }
    public void click(){
        if(enabled){
            System.out.println("Login Successful");
        }else{
            System.out.println("Login Failed");
        }
        //required to set status of login
        notifyMediator();
    }
    public boolean getEnabled(){return enabled;}
}
