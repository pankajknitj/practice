package main.lld.behavioral.mediator.impl;

import lombok.Data;
import main.lld.behavioral.mediator.face.UIComponent;
import main.lld.behavioral.mediator.face.UIMediator;

//concrete component
public class TextField extends UIComponent {
    private String text;
    public TextField(UIMediator mediator) {
        super(mediator);
    }

    public void setText(String text){
        this.text = text;
        notifyMediator();
    }
    public String getText(){ return text;}
}
