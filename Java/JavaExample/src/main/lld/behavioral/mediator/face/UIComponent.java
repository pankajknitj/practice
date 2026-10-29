package main.lld.behavioral.mediator.face;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Component contract
public abstract class UIComponent {
    private UIMediator mediator;
    //after performing the operation concrete component notifies the mediator
    protected void notifyMediator(){
        mediator.componentChange(this);
    }
}
