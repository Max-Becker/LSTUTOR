package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Lesson {
    Image lesson1 = new Image("/resources/Lesson1.png");
    Image lesson2 = new Image("/resources/lesson2.png");
    //Image lesson3 = new Image("");
    //Image lesson4 = new Image("");
    ImageView lessonImage;

    public void Lesson(int number){
        ImageView lessonImage = new ImageView("lesson"+number);
    }
    public void setLesson(int number)
    {

    }
    public ImageView getLessonImage()
    {
        return lessonImage;
    }
}
