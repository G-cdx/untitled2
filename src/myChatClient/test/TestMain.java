package myChatClient.test;

import com.sun.javafx.robot.FXRobot;
import com.sun.javafx.robot.FXRobotImage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.channels.FileChannel;

public class TestMain extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        final Group group = new Group();
        final Scene scene = new Scene(group, 600, 400, Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.setTitle("JavaFX 2 Animations");
        stage.show();
        //final Circle circle = new Circle(20, 100, 15);
        //circle.setFill(Color.DARKRED);
        Pane p = new Pane();
        p.setStyle("-fx-background-color: black");
        p.setPrefWidth(20);
        p.setPrefHeight(20);
        final Path path = new Path();
        path.getElements().add(new MoveTo(20, 100));
        path.getElements().add(new CubicCurveTo(20, 100, 0, 100, 200, 100));
//        path.getElements().add(new CubicCurveTo(200, 1120, 110, 240, 380, 240));
        path.setOpacity(0);

        //group.getChildren().add(path);
        group.getChildren().add(p);
        final PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.seconds(8.0));
        pathTransition.setDelay(Duration.seconds(.5));
        pathTransition.setPath(path);
        pathTransition.setNode(p);
        pathTransition
                .setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okk");
            }
        });
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
}
