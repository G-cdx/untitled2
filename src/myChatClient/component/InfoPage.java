package myChatClient.component;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import myChatClient.bean.User;
import myChatClient.utils.GlobalState;

import java.util.List;


public class InfoPage extends ImageItem{

    public AnchorPane getPersonPane(String name,String id,String imgURL)
    {
        imgURL = GlobalState.imgURL;
        AnchorPane anchorPane = getAnchorPane();
        Label headLabel = getLabel("好友信息",95,11,200,60,19);
        Label nameLabel = getLabel(name,120,160,200,100,15);
        ImageView avator = getImageView(imgURL,60,60);
        avator.setLayoutX(105);
        avator.setLayoutY(120);
        Button button = getButton("删除好友",40, 491,220,40,17);
        anchorPane.getChildren().addAll(headLabel,nameLabel,avator,button);
        return anchorPane;
    }

    public AnchorPane getGroupPane(String name, String id, List<User> list)
    {
        FlowPane flowPane = getFlowPane();
        Label headLabel = getLabel("群信息",105,11,200,60,19);
        Label nameLabel = getLabel("群名称："+name,33,51,200,100,15);
        Label idLabel = getLabel("群ID  ："+id,34,85,200,100,15);
        Button button = getButton("删除并退出",40, 491,220,40,17);
        AnchorPane anchorPane = getAnchorPane();
        anchorPane.getChildren().addAll(headLabel,nameLabel,idLabel,flowPane,button);
//        for(int i = 0;  i < 10 ;i++)
//            list.add(new User(i,"张三"));
//        for(User u  : list)
//        {
//
//            Pane p = getPane(60,60);
//            p.getChildren().add(getImageView("img/profile.jpg",40,40));
//            p.getChildren().add(getLabel(u.getUsername(),-1,-1,40,20,10));
//            flowPane.getChildren().add(p);
//        }
        return anchorPane;
    }

    public Pane getPane(double w,double h)
    {
        Pane pane = new Pane();
        pane.setPrefHeight(h);
        pane.setPrefWidth(w);
        return pane;
    }

    public AnchorPane getAnchorPane()
    {
        AnchorPane pane = new AnchorPane();
        pane.setPrefHeight(600);
        pane.setPrefWidth(300);
        pane.setStyle("-fx-background-color: rgb(243,251,253);-fx-border-color: rgb(245,245,245);-fx-border-width: 2");
        return pane;
    }

    public Label getLabel(String message,double x,double y,double w,double h,double size)
    {
        Label label = new Label(message);
        label.setPrefHeight(h);
        label.setPrefWidth(w);
        if(x != -1) label.setLayoutX(x);
        if(y != -1) label.setLayoutY(y);
        label.setFont(Font.font(size));
        return label;
    }

    public FlowPane getFlowPane()
    {
        FlowPane flowPane = new FlowPane();
        flowPane.setPrefHeight(300);
        flowPane.setPrefWidth(240);
        flowPane.setLayoutX(30);
        flowPane.setLayoutY(160);
        return flowPane;
    }

    public Button getButton(String name,double x,double y,double w,double h,double size)
    {
        Button button = new Button();
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefHeight(h);
        button.setPrefWidth(w);
        button.setText(name);
        button.setFont(Font.font(size));
        button.setStyle("-fx-background-color: rgb(248,84,84); -fx-background-radius: 15;");
        return button;
    }
}
