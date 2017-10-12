package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Lesson {

    private Image lesson1 = new Image("/resources/Lesson1.png");
    Image lesson2 = new Image("/resources/lesson2.png");
  //  Image lesson3 = new Image("");
    //Image lesson4 = new Image("");
    Image lessonImage;
    private int number;

    public Lesson(int number){
        this.number = number;
        switch (number) {
            case 1:
                lessonImage = lesson1;
                break;
            case 2:
                lessonImage = lesson2;
                break;
//            case 3:
//                lessonImage = lesson3;
//                break;
//            case 4:
//                lessonImage = lesson4;
//                break;
        }
    }
    public void setLesson(int number)
    {

    }

    public Image getLessonImage()
    {
        return lessonImage;
    }
}
