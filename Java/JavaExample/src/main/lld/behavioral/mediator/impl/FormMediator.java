package main.lld.behavioral.mediator.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import main.lld.behavioral.mediator.face.UIComponent;
import main.lld.behavioral.mediator.face.UIMediator;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
//Concrete implementation of mediator
public class FormMediator implements UIMediator {
    private TextField username;
    private TextField password;
    private Label label;
    private Button button;

    //For mediator it is expected to know the type of component to perform action
    @Override
    public void componentChange(UIComponent component) {
        if(component == username || component ==password){
            boolean enabled = !StringUtils.isEmpty(username.getText()) && !StringUtils.isEmpty(password.getText());
            button.setEnabled(enabled);
        }else if(component == button){
            if(button.getEnabled()) label.setLabel("Logged In");
            else label.setLabel("Failed Login");
        }
    }
}
