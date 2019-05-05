package myChatClient.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class LeftController {
    public VBox left;
    public ImageView chat;
    public ImageView friend;
    public ImageView person;

    public void onblur(){
        friend.setImage(new Image("img/friend1.png"));
        person.setImage(new Image("img/person1.png"));
        chat.setImage(new Image("img/chat1.png"));
    }

    public void chatClick(MouseEvent mouseEvent) {
        onblur();
        chat.setImage(new Image("img/chat2.png"));
    }

    public void friendClick(MouseEvent mouseEvent) {
        onblur();
        friend.setImage(new Image("img/friend2.png"));
    }

    public void personClick(MouseEvent mouseEvent) {
        onblur();
        person.setImage(new Image("img/person2.png"));
    }
}
