package myChatClient.component;

import javafx.beans.value.ObservableDoubleValue;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodRequests;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import myChatClient.utils.EmojSet;
import myChatClient.utils.GlobalState;

public class ChatItem extends ImageItem{
    public HBox getChatItem(String username,String imgUrl,String message,boolean flag){
        imgUrl = GlobalState.imgURL;
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,30));
        //自己的聊天项
        if(flag == true)
            hBox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        TextFlow textFlow = getMessage(message,flag);
        Label label = new Label(username);
        hBox.getChildren().addAll(getImageView(imgUrl,35,35),label,textFlow);
        return hBox;
    }

    /**
     * 获取消息控件
     * */
    private TextFlow getMessage(String message,Boolean flag){
        TextFlow textFlow = new TextFlow();
        textFlow.setMaxWidth(300);
        String [] messArray = message.split("/");
        if(messArray.length > 1){
            for(String s : messArray){
               // System.out.println(s);
                if(s.length() >= 3 && EmojSet.emojSet.contains(s.substring(0,3)) != false){
                    textFlow.getChildren().add(getImageView("img/emoj"+s.substring(0,3)+".png",28,28));
                    if(s.substring(3).length() > 0)
                    {
                        Text text = new Text();
                        text.setFont(Font.font(14));
                        text.setText(s.substring(3));
                        textFlow.getChildren().add(text);
                    }
                }
                else if(s.length() > 0 ){
                    Text text = new Text();
                    text.setFont(Font.font(14));
                    text.setText(s);
                    textFlow.getChildren().add(text);
                }
            }
        }
        else{
            Text text = new Text();
            text.setFont(Font.font(14));
            text.setText(message);
            textFlow.getChildren().add(text);
        }
        textFlow.setPadding(new Insets(5,10,5,10));
        textFlow.setTranslateX(15);
        textFlow.setTranslateY(5);
        textFlow.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);


        if(flag == true)
            textFlow.setStyle("-fx-background-color: rgb(62,223,255);-fx-background-radius:3");
        else
            textFlow.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius:3");
        return textFlow;
    }
}
