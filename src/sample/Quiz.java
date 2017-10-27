package sample;

import javafx.scene.image.Image;

public class Quiz {

    Image quiz1 = new Image("/resources/q1.png");
    Image quiz2 = new Image("/resources/q2.png");
    Image quiz3 = new Image("/resources/q3.png");
    Image quiz4 = new Image("/resources/q4.png");
    Image quiz5 = new Image("/resources/q5.png");
    Image quiz6 = new Image("/resources/q6.png");
    Image quiz7 = new Image("/resources/q7.png");
    Image quiz8 = new Image("/resources/q7.png");
    Image quiz9 = new Image("/resources/q9.png");
    Image quiz10 = new Image("/resources/q10.png");
    Image questionImage;
    char q1 = 'b';
    char q2 = 'c';
    char q3 = 'a';
    char q4 = 'c';
    char q5 = 'c';
    char q6 = 'a';
    char q7 = 'b';
    char q8 = 'a';
    char q9 = 'c';
    char q10 = 'b';
    char answer;

    public Quiz(int num)
    {
        switch(num){
            case 1: answer = q1;
            questionImage = quiz1;
            break;
            case 2:answer = q2;
                questionImage = quiz2;
                break;
            case 3:answer = q3;
                questionImage = quiz3;
                break;
            case 4:answer = q4;
                questionImage = quiz4;
                break;
            case 5:answer = q5;
                questionImage = quiz5;
                break;
            case 6:answer = q6;
                questionImage = quiz6;
                break;
            case 7:answer = q7;
                questionImage = quiz7;
                break;
            case 8:answer = q8;
                questionImage = quiz8;
                break;
            case 9:answer = q9;
                questionImage = quiz9;
                break;
            case 10:answer = q10;
                questionImage = quiz10;
                break;
        }
    }
    public Image getQuizImage()
    {
        return questionImage;
    }

    public char getQuizAnswer()
    {
        return answer;
    }

}
