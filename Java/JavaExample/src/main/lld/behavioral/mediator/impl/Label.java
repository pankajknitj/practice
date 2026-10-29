package main.lld.behavioral.mediator.impl;

import main.lld.behavioral.mediator.face.UIComponent;
import main.lld.behavioral.mediator.face.UIMediator;

public class Label extends UIComponent {
    private String label;
    public Label(UIMediator mediator) {
        super(mediator);
    }
    public void setLabel(String label){
        this.label = label;
        notifyMediator();
    }
    public String getLabel(){return label;}
}
