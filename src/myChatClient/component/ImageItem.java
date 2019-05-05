package myChatClient.component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import myChatClient.utils.GlobalState;

public class ImageItem {
    public ImageView getImageView(String imgUrl, double width, double height){
        imgUrl = GlobalState.imgURL;
        //imageView
        ImageView imageView = new ImageView();
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setTranslateY(5);
        imageView.setImage(new Image(imgUrl));
        return imageView;
    }
}
