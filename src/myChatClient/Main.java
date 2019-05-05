package myChatClient;

import com.sun.javafx.robot.FXRobot;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import myChatClient.api.InitUtil;
import myChatClient.component.ChatItem;
import myChatClient.controller.CenterController;
import myChatClient.controller.RightController;
import myChatClient.utils.GlobalState;

import java.io.IOException;


public class Main extends Application {
    static public Stage stage;
    static public HBox root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        AnchorPane loginLoader = FXMLLoader.load(getClass().getResource("view/fxml/login/Login.fxml"));
        //先加载登录面板
        Scene scene = new Scene(loginLoader);
        primaryStage.setScene(scene);
        primaryStage.show();
        //加载各个面板
        loaderPane();
        //初始化好友列表

        GlobalState.groupChatController.setUserList(GlobalState.userManager.getUserList());
        GlobalState.userManager.renderFriendList(null,null);

    }

    public void loaderPane() throws IOException {
        //加载根节点
        root = FXMLLoader.load(getClass().getResource("view/fxml/Root.fxml"));
        //若点击外侧，则取消表情面板
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(RightController.emojStage != null)
                {
                    GlobalState.emojPane.setStyle("-fx-background-color: null");
                    RightController.emojStage.close();
                    RightController.emojStage = null;
                }
            }
        });
        //加载左侧面板
        VBox left = FXMLLoader.load(getClass().getResource("view/fxml/Left.fxml"));
        root.getChildren().add(left);
        //加载好友列表面板
        FXMLLoader centerLoader = new FXMLLoader(getClass().getResource("view/fxml/Center.fxml"));
        VBox center = centerLoader.load();
        root.getChildren().add(center);
        //加载右侧聊天面板
        FXMLLoader rightLoader = new FXMLLoader(getClass().getResource("view/fxml/Right.fxml"));
        VBox right = rightLoader.load();
        root.getChildren().add(right);
    }

    public void go(String[] args) {
        launch(args);
    }
}
