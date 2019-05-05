package myChatClient.controller;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import myChatClient.Main;
import myChatClient.api.SendAPI;
import myChatClient.bean.TalkItem;
import myChatClient.bean.User;
import myChatClient.bean.UserInfo;
import myChatClient.component.ChatItem;
import myChatClient.component.EmojPane;
import myChatClient.component.InfoPage;
import myChatClient.component.MessageItemFactory;
import myChatClient.utils.EmojSet;
import myChatClient.utils.GlobalState;
import myChatClient.utils.SendMessage;

import java.util.ArrayList;


public class RightController {
    public Pane close;
    public Pane biggest;
    public Pane smallest;
    public TextField textField;
    public ToolBar toolBar;
    public VBox scrollPaneVBox;
    public ScrollPane scrollerPane;
    public TextFlow textFlow;
    public Pane emojP;
    public Pane fileP;
    public Pane moreP;
    public Label chatNameLabel;
    public Pane moreInfo;
    private double xOffset;
    private double yOffset;
    private double stageX;
    private double stageY;
    private ChatItem chatItem = new ChatItem();
    public static Stage emojStage = null;
    public static TextField myTextField;
    private boolean emojClicked = false;

    private MessageItemFactory messageItemFactory = new MessageItemFactory();
    public void mouseDragged(MouseEvent mouseEvent) {
        Main.stage.setX(stageX+ mouseEvent.getScreenX() - xOffset);
        Main.stage.setY(stageY+ mouseEvent.getScreenY() - yOffset);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getScreenX();
        yOffset = mouseEvent.getScreenY();
        stageX = Main.stage.getX();
        stageY = Main.stage.getY();
    }

    public void closeClicked(MouseEvent mouseEvent) {
        Main.stage.close();
    }

    public void closeEntered(MouseEvent mouseEvent) {
        close.setStyle("-fx-background-color:rgb(248,84,84)");
    }

    public void closeExited(MouseEvent mouseEvent) {
        close.setStyle("-fx-background-color:null");
    }

    public void biggestClicked(MouseEvent mouseEvent) {
        Main.stage.setFullScreen(true);
    }

    public void biggestEntered(MouseEvent mouseEvent) {
        biggest.setStyle("-fx-background-color:rgb(81,183,220)");
    }

    public void smallExited(MouseEvent mouseEvent) {
        biggest.setStyle("-fx-background-color:null");
    }

    public void smallestClick(MouseEvent mouseEvent) {
        Main.stage.setIconified(true);
    }

    public void smallestEntered(MouseEvent mouseEvent) {
        smallest.setStyle("-fx-background-color:rgb(81,183,220)");
    }

    public void smallestExited(MouseEvent mouseEvent) {
        smallest.setStyle("-fx-background-color:null");
    }

    public void toolBarClicked(MouseEvent mouseEvent) {
    }

    public void textFieldRequest(ContextMenuEvent contextMenuEvent) {

    }
    @FXML
    public void initialize(){
        myTextField = textField;
        GlobalState.chatVBox = scrollPaneVBox;
        GlobalState.scrollerPane = scrollerPane;
        GlobalState.textField = textField;
        GlobalState.userManager.setChatVBox(scrollPaneVBox);
        GlobalState.userManager.setChatNameLabel(chatNameLabel);
        GlobalState.emojPane = emojP;
        /**初始化表情数据*/
        for(int i = 0; i<84; i++)
        {
            String imgName;
            if(i == 0) imgName = "000";
            else if(i < 10) imgName = "00"+i;
            else imgName = "0"+i;
            EmojSet.emojSet.add(imgName);
        }
    }
    public void textFieldPressed(KeyEvent keyEvent) {

        if(keyEvent.getCode().getName().equals("Enter") && GlobalState.userManager.getCurrentUser().getUserInfo() != null)
        {
                //取得当前聊天对象id
                String targetId = GlobalState.userManager.getCurrentUser().getUserInfo().getId();
                //是否群聊
                boolean isGroup = GlobalState.userManager.getCurrentUser().getUserInfo().isGroup();
                System.out.println(isGroup);
                //取得自己id
                String myId = GlobalState.userManager.getMyInfo().getId();
                //文字信息
                int type = 0;
                //发送信息
                String message = textField.getText();
                if(isGroup)
                    new SendAPI().sendGroupChatMessage(myId,targetId,message);
                else new SendAPI().sendWordMessage(myId,targetId,message);
                //根据对象id获得userInfo
                UserInfo userInfo = GlobalState.userManager.getUserInfoById(targetId);
                //封装信息
                TalkItem talkItem = new TalkItem(type,myId,myId,textField.getText(),"img/profile"+myId+".jpg","");
                //添加到目标聊天列表
                userInfo.getMessages().add(talkItem);
                //追加到聊天框
                scrollPaneVBox.getChildren().add(messageItemFactory.getItem(talkItem));
                //追加到最新消息
                Label label = (Label)GlobalState.userManager.getCurrentUser().getUserInfoPane().getChildren().get(2);
                label.setText(textField.getText());
                //清空输入框
                textField.clear();
        }
    }

    public void textFieldReleased(KeyEvent keyEvent) {
        if(keyEvent.getCode().getName().equals("Enter"))
        {
            scrollerPane.setVvalue(1);
        }
    }

    public void mouseExited(MouseEvent mouseEvent) {
        scrollerPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        scrollerPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    public void emojClick(MouseEvent mouseEvent) {
        if(emojStage == null)
        {
            emojStage = new EmojPane().getEmojPane();
            emojClicked = true;
            emojP.setStyle("-fx-background-color:rgb(225,228,230);-fx-background-radius: 5px");
            emojStage.show();
        }
    }
    public void fileMouseEntered(MouseEvent mouseEvent) {
        fileP.setStyle("-fx-background-color:rgb(224,227,229)");
    }

    public void emojMouseExited(MouseEvent mouseEvent) {
        if(!emojClicked)
        emojP.setStyle("-fx-background-color:null;-fx-background-radius: 5px");
    }

    public void fileMouseExited(MouseEvent mouseEvent) {
        fileP.setStyle("-fx-background-color:null");
    }

    public void emojMouseEntered(MouseEvent mouseEvent) {
        if(!emojClicked)
        emojP.setStyle("-fx-background-color:rgb(236,239,241);-fx-background-radius: 5px");
    }

    public void moreMouseEntered(MouseEvent mouseEvent) {
        moreP.setStyle("-fx-background-color:rgb(224,227,229)");
    }

    public void moreMouseExited(MouseEvent mouseEvent) {
        moreP.setStyle("-fx-background-color:null");
    }

    public void textFieldMouseClicked(MouseEvent mouseEvent) {
        if(RightController.emojStage != null)
        {
            emojP.setStyle("-fx-background-color:null;-fx-background-radius: 5px");
            emojClicked = false;
            RightController.emojStage.close();
            emojStage = null;
        }
    }

    public void moreInfoClicked(MouseEvent mouseEvent) {
        String id = GlobalState.userManager.getCurrentUser().getUserInfo().getId();
        String name = GlobalState.userManager.getCurrentUser().getUserInfo().getUsername();
        HBox hBox = (HBox)Main.stage.getScene().getRoot();
        if(hBox.getChildren().size() <= 3) {
            Main.stage.setWidth(1200);
            hBox.getChildren().add(new InfoPage().getPersonPane(name, id, "img/profile"+id+".jpg"));
        }else
        {
            hBox.getChildren().remove(3);
            Main.stage.setWidth(920);
        }
    }

    public void moreInfoEntered(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView)moreInfo.getChildren().get(0);
        imageView.setImage(new Image("img/more3.png"));
    }

    public void moreInfoExited(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView)moreInfo.getChildren().get(0);
        imageView.setImage(new Image("img/more2.png"));
    }
}
