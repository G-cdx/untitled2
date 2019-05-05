package myChatClient.utils;


import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import myChatClient.bean.UserInfo;
import myChatClient.controller.GroupChatManager;
import myChatClient.controller.UserManager;

public class GlobalState {
    public static VBox chatVBox;
    public static ScrollPane scrollerPane;
    public static TextField textField;

    public static UserManager userManager = new UserManager();
    public static GroupChatManager groupChatController = new GroupChatManager();
    public static int cnt = 0;
    public static Pane emojPane;
    public static Stage groupStage;

    public static String imgURL = "img/profile.jpg";
}
