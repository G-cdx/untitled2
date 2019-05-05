package myChatClient.controller;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;
import myChatClient.Main;
import myChatClient.utils.GlobalState;

import java.io.IOException;

public class CenterController {
    public ScrollPane scrollerPane;

    public VBox friendVBox;
    public Pane addPane;

    @FXML
    public void initialize(){
        GlobalState.userManager.setFriendsVBox(friendVBox);
    }
    public void mouseExited(MouseEvent mouseEvent) {
        scrollerPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        scrollerPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    public void onAddClick(MouseEvent mouseEvent) throws IOException {
       GlobalState.groupChatController.go();
        Rectangle rect = new Rectangle(20,20,20,20);
        rect.setFill(Paint.valueOf("black"));
    }

    public void addMouseEntered(MouseEvent mouseEvent) {
        addPane.setStyle("-fx-background-color: rgb(209,209,209); -fx-background-radius: 4;");
    }

    public void addMouseExited(MouseEvent mouseEvent) {
        addPane.setStyle("-fx-background-color: rgb(220,217,216); -fx-background-radius: 4;");
    }
}
