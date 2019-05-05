package myChatClient.component;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class FileItem extends ImageItem{
    public HBox getFileItem(String name,String imgUrl, String message, Boolean flag){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,30));
        hBox.setPrefHeight(113);
        hBox.setMinHeight(113);
        hBox.setPrefWidth(500);
        if(flag == true)
            hBox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        Pane pane = getFilePane(message,flag);
        addEvent(pane);
        hBox.getChildren().addAll(getImageView(imgUrl,35,35),pane);
        return hBox;
    }

    public Pane getFilePane(String mess,boolean flag)
    {
        Pane pane = new Pane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        pane.setPrefHeight(80);
        pane.setPrefWidth(200);
        pane.setStyle("-fx-background-color: white;-fx-border-color: rgb(237,237,237);-fx-border-width: 2");
        pane.setTranslateX(20);
        HBox hBox = new HBox();

        //文件图标
        ImageView fileImg = getImageView("img/file2.png",50,50);
        fileImg.setTranslateX(10);
        fileImg.setTranslateY(8);

        //文件信息
        Label label = new Label(mess);
        label.setTranslateY(11);
        label.setTranslateX(20);
        label.setFont(Font.font(16));
        label.setAlignment(Pos.TOP_LEFT);

        //分隔行
        Separator separator = new Separator();
        separator.setLayoutY(63);
        separator.setPrefWidth(200);
        separator.setPrefHeight(1);

        //标注
        Label subLabel = new Label("文件信息");
        subLabel.setLayoutY(61);
        subLabel.setLayoutX(8);
        subLabel.setPrefHeight(23);
        subLabel.setPrefWidth(50);
        subLabel.setTextFill(Paint.valueOf("#8d8888"));


        hBox.setPrefWidth(200);
        hBox.setPrefHeight(60);
        hBox.setLayoutX(1);
        hBox.setLayoutY(1);
        hBox.getChildren().addAll(fileImg,label);
        if(flag)
            hBox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        pane.getChildren().addAll(hBox,separator,subLabel);
        return pane;
    }

    public void addEvent(Pane pane)
    {
        pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.setStyle("-fx-background-color: rgb(246,247,247);-fx-border-color:rgb(237,237,237);-fx-border-width: 2");
            }
        });
        pane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.setStyle("-fx-background-color: white;-fx-border-color: rgb(237,237,237);-fx-border-width: 2");
            }
        });
//        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Stage mainStage = null;
//                FileChooser fileChooser = new FileChooser();//构建一个文件选择器实例
//                File selectedFile = fileChooser.showOpenDialog(mainStage);
//            }
//        });
    }
}
