package myChatClient.controller;

import client.Send;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import myChatClient.api.SendAPI;
import myChatClient.utils.SendMessage;

public class LoginController {
    public PasswordField password;
    public TextArea account;

    public void onLoginClicked(MouseEvent mouseEvent) {
        String pwd = password.getText();
        String acnt = account.getText();
        new SendAPI().sendLoginMessage(acnt,pwd);
    }
}
