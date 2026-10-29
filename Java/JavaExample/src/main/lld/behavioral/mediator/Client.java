package main.lld.behavioral.mediator;

import main.lld.behavioral.mediator.impl.Button;
import main.lld.behavioral.mediator.impl.FormMediator;
import main.lld.behavioral.mediator.impl.Label;
import main.lld.behavioral.mediator.impl.TextField;

public class Client {
    public static void main(String[] args) {
        FormMediator form = new FormMediator();

        TextField username = new TextField(form);
        TextField pass = new TextField(form);
        Label label = new Label(form);
        Button button = new Button(form);

        form.setButton(button);
        form.setPassword(pass);
        form.setUsername(username);
        form.setLabel(label);

        username.setText("pankaj");
        button.click(); //failed
        pass.setText("122323");
        button.click(); //success
    }
}
