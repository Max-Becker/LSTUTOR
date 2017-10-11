package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Lesson {
<<<<<<< HEAD
    Image lesson1 = new Image("/resources/Lesson1.png");
    Image lesson2 = new Image("/resources/lesson2.png");
    //Image lesson3 = new Image("");
    //Image lesson4 = new Image("");
    ImageView lessonImage;

    public void Lesson(int number){
        ImageView lessonImage = new ImageView("lesson"+number);
=======
    private Image lesson1 = new Image("/resources/Lesson1.png");
//    Image lesson2 = new Image("");
  //  Image lesson3 = new Image("");
    //Image lesson4 = new Image("");
    Image lessonImage;
    private int number;

    public Lesson(int number){
        this.number = number;
        switch (number) {
            case 1:
                lessonImage = lesson1;

//            case 2:
//                lessonImage = lesson2;
//                break;
//            case 3:
//                lessonImage = lesson3;
//                break;
//            case 4:
//                lessonImage = lesson4;
//                break;
        }
>>>>>>> origin/master
    }
    public void setLesson(int number)
    {

    }
<<<<<<< HEAD
    public ImageView getLessonImage()
=======
    public Image getLessonImage()
>>>>>>> origin/master
    {
        return lessonImage;
    }
}
