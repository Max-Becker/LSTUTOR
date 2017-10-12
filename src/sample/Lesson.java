package sample;

import javafx.scene.image.Image;

public class Lesson {

    private Image lesson1 = new Image("/resources/Lesson1.png");
    Image lesson2 = new Image("/resources/lesson2.png");
    Image lesson3 = new Image("/resources/ChainRule2.jpg");
    Image lesson4 = new Image("/resources/ExponentialRule2.jpg");
//    Image question11 = new Image("");
//    Image question12 = new Image("");
//    Image question13 = new Image("");
//    Image question21 = new Image("");
//    Image question22 = new Image("");
//    Image question23 = new Image("");
    Image question31 = new Image("/resources/ChainQuestion1.png");
    Image question32 = new Image("/resources/ChainQuestion2.png");
    Image question33 = new Image("/resources/ChainQuestion3.png");
//    Image question41 = new Image("");
//    Image question42 = new Image("");
//    Image question43 = new Image("");
    Image question1, question2, question3;
    char q1a = 'c';
    char q1b = 'a';
    char q1c = 'c';
    char q2a;
    char q2b;
    char q2c;
    char q3a = 'c';
    char q3b = 'a';
    char q3c = 'c';
    char q4a;
    char q4b;
    char q4c;
    char answer1;
    char answer2;
    char answer3;

    Image lessonImage;
    private int number;

    public Lesson(int number){
        this.number = number;
        switch (number) {
            case 1:
                lessonImage = lesson1;
//                question1 = question11;
//                question2 = question12;
//                question3 = question13;
                answer1 = q1a;
                answer2 = q1b;
                answer3 = q1c;
                break;
            case 2:
                lessonImage = lesson2;
//                question1 = question21;
//                question2 = question22;
//                question3 = question23;
                answer1 = q2a;
                answer2 = q2b;
                answer3 = q2c;
                break;
            case 3:
                lessonImage = lesson3;
                question1 = question31;
                question2 = question32;
                question3 = question33;
                answer1 = q3a;
                answer2 = q3b;
                answer3 = q3c;
                break;
            case 4:
                lessonImage = lesson4;
//                question1 = question41;
//                question2 = question42;
//                question3 = question43;
                answer1 = q4a;
                answer2 = q4b;
                answer3 = q4c;
                break;
        }
    }
    public void setLesson(int number)
    {

    }

    public Image getLessonImage()
    {
        return lessonImage;
    }
    public Image[] getQuestionImages()
    {
        Image[] imgArray = {question1, question2, question3};
        return imgArray;
    }

    public char[] getAnswers(){
        char[] answers = {answer1, answer2, answer3};
        return answers;
    }
}
