package sample;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;

import javax.swing.*;
//import java.awt.;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends Main implements Initializable {

    @FXML private Button SubmitAll;
    @FXML private TextField UsernameField;
    @FXML private PasswordField passfield;
    @FXML ImageView hamburgerView = new ImageView();
    @FXML ImageView userView = new ImageView();
    @FXML ImageView logoView = new ImageView();
    @FXML ImageView logoView1 = new ImageView();
    @FXML Label userNameLabel = new Label();
    @FXML ImageView lessonImage = new ImageView();
    @FXML ImageView question1 = new ImageView();
    @FXML ImageView question2 = new ImageView();
    @FXML ImageView question3 = new ImageView();
    @FXML Label lessonTitle, labelLesson,labelLesson1,labelLesson2,labelLesson3,quizGradeLabel,totalGrade = new Label();
    @FXML Pane sideMenuPane, lessonMenuPane, loginPane, gradePane, quizPane, lessonPane, mainMenuPane = new Pane();

    private  String userInput = null;
    private String passInput = null;
    private Boolean truelogin = false;
    UserList linkedlist = new sample.UserList();
    //ReadandWrite getData = new ReadandWrite();
    JFrame frame = new JFrame();
    int lessonState = 0;
    char[] answers = new char[3];
    char[] userAnswers = new char[3];
    private int grade1 = 0, grade2 = 0, grade3 = 0, grade4 = 0, gradeQuiz = 0;
    Image hamburger = new Image("/resources/hamburger.png");
    Image userIcon = new Image("/resources/usericon.png");
    Image logo = new Image("/resources/dsdt.png");

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
       // getData.readfromFile();
        hamburgerView.setImage(hamburger);
        userView.setImage(userIcon);
        logoView.setImage(logo);
        logoView1.setImage(logo);
        switchPane("logIn");
    }

    @FXML

    public void loginButtonHandler(ActionEvent event) throws Exception
    {
        userInput = UsernameField.getText();
        passInput = passfield.getText();
        node temp = linkedlist.getNode();
        node first = temp;
        if(linkedlist.isEmpty()== true)
        {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("Users");
            alert.setHeaderText("No accounts registered");
            alert.showAndWait();
        }
        else
        {

            while (temp != null)
            {
                if (temp.userName.equals(userInput))
                {
                    if (temp.password.equals(passInput)) {
                        truelogin = true;
                        userNameLabel.setText(temp.userName);
                        switchPane("mainMenu");
                    }
                    else
                    {
                        Alert alert = new Alert((Alert.AlertType.ERROR));
                        alert.setTitle("Acount Not Found");
                        alert.setHeaderText("Incorrect Password");
                        alert.showAndWait();

                    }
                }
                else if(truelogin == false)
                {
                    Alert alert = new Alert((Alert.AlertType.ERROR));
                    alert.setTitle("Found?");
                    alert.setHeaderText("Account not found");
                    alert.showAndWait();
                }
                temp = temp.next;
            }
            truelogin = false;


        }


    }


    public void createAccountHandler() throws Exception
    {
        userInput = UsernameField.getText();
        passInput = passfield.getText();
        linkedlist.add(userInput, passInput, grade1, grade2, grade3, grade4, gradeQuiz);
        Alert alert = new Alert((Alert.AlertType.CONFIRMATION));
        alert.setTitle("Confirmed");
        alert.setHeaderText("Account Created");
        alert.showAndWait();
        linkedlist.printUsers();
        //getData.writeToFile(userInput, passInput,grade);
    }

    //Side Menu
    @FXML
    public void sideMenuButtonHandler() throws Exception {
        sideMenuPane.setVisible(true);
    }

    @FXML
    public void closeButtonHandler() throws Exception {
        sideMenuPane.setVisible(false);
    }

    @FXML
    public void quizHandler() {
        switchPane("quiz");
    }

    @FXML
    public void gradeHandler() {
        switchPane("grades");
        labelLesson.setText(Double.toString((double)grade1*100/3));
        labelLesson1.setText(Double.toString((double)grade2*100/3));
        String grade3String = Double.toString((double)grade3*100/3);

        labelLesson2.setText(Double.toString((double)grade3*100/3));
        String grade4String = Double.toString((double)grade4*100/3);
        labelLesson3.setText(grade4String);
        quizGradeLabel.setText(Double.toString((double)gradeQuiz));
        double gradetot = (((double)grade1*100/3+(double)grade2*100/3+(double)grade3*100/3+
                (double)grade4*100/3)/4*.5+(double)gradeQuiz*100/10*.5);
        totalGrade.setText(Double.toString(gradetot));
    }

    @FXML
    public void logoutHandler() {
        switchPane("logIn");
    }

    @FXML
    public void lessonMenuHandler() {
        switchPane("lessonMenu");
    }

    @FXML public void Q1A(){userAnswers[0] = 'a';}
    @FXML public void Q1B(){userAnswers[0] = 'b';}
    @FXML public void Q1C(){userAnswers[0] = 'c';}
    @FXML public void Q2A(){userAnswers[1] = 'a';}
    @FXML public void Q2B(){userAnswers[1] = 'b';}
    @FXML public void Q2C(){userAnswers[1] = 'c';}
    @FXML public void Q3A(){userAnswers[2] = 'a';}
    @FXML public void Q3B(){userAnswers[2] = 'b';}
    @FXML public void Q3C(){userAnswers[2] = 'c';}
    //Lessons

    @FXML public void submitButtonHandler() throws Exception {
        String currentLesson = lessonTitle.getText();
        if (currentLesson .equals("Product Rule"))
        {
            productRuleSubmit();
        }
        if (currentLesson .equals("Power Rule"))
        {
            powerRuleSubmit();
        }
        if (currentLesson .equals("Chain Rule"))
        {
            chainRuleSubmit();
        }
        if (currentLesson .equals("Exponential Rule"))
        {
            exponentRuleSubmit();
        }
    }
    @FXML
    public void productRuleHandler() {
        switchPane("lessons");
        Lesson lesson2 = new Lesson(2);
        lessonImage.setImage(lesson2.getLessonImage());
        Image[] imgArray = lesson2.getQuestionImages();
        question1.setImage(imgArray[0]) ;
        question2.setImage(imgArray[1]);
        question3.setImage(imgArray[2]) ;
        lessonState = 2;
        answers = lesson2.getAnswers();
        lessonTitle.setText("Product Rule");
    }

    @FXML public void productRuleSubmit() throws Exception {int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade2 = count;
    displayReaction(grade2);
    }

    @FXML
    public void powerRuleHandler() {
        switchPane("lessons");
        Lesson lesson1 = new Lesson(1);
        lessonImage.setImage(lesson1.getLessonImage());
        Image[] imgArray = lesson1.getQuestionImages();
        question1.setImage(imgArray[0]) ;
        question2.setImage(imgArray[1]);
        question3.setImage(imgArray[2]) ;
        lessonState = 1;
        answers = lesson1.getAnswers();
        lessonTitle.setText("Power Rule");

    }
    @FXML public void powerRuleSubmit() throws Exception {int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade1 = count;
        displayReaction(grade1);
    }

    @FXML
    public void chainRuleHandler() {
        switchPane("lessons");
        Lesson lesson3 = new Lesson(3);
        lessonImage.setImage(lesson3.getLessonImage());
        Image[] imgArray = lesson3.getQuestionImages();
        question1.setImage(imgArray[0]) ;
        question2.setImage(imgArray[1]);
        question3.setImage(imgArray[2]) ;
        lessonState = 3;
        answers = lesson3.getAnswers();
        lessonTitle.setText("Chain Rule");

    }
    @FXML public void chainRuleSubmit() throws Exception {        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade3 = count;
        displayReaction(grade3);
    }

    @FXML
    public void exponentRuleHandler() {
        switchPane("lessons");
        Lesson lesson4 = new Lesson(4);
        lessonImage.setImage(lesson4.getLessonImage());
        Image[] imgArray = lesson4.getQuestionImages();
        question1.setImage(imgArray[0]) ;
        question2.setImage(imgArray[1]);
        question3.setImage(imgArray[2]) ;
        lessonState = 4;
        answers = lesson4.getAnswers();
        lessonTitle.setText("Exponential Rule");
    }

    @FXML public void exponentRuleSubmit() throws Exception {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade4 = count;
        displayReaction(grade2);
    }


    @FXML
    public void nextLesson(){
    switch(lessonState)
    {
        case 1: productRuleHandler();
            break;
        case 2: chainRuleHandler();
            break;
        case 3: exponentRuleHandler();
            break;
        case 4: switchPane("mainMenu");
            break;

    }
    }

    public void displayReaction(int correct) throws Exception {
        if (correct == 3) {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("GreatJob.fxml"));
            Scene newScene = new Scene(newSceneRoot, 640, 400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        } else if (correct == 2) {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("NotQuite.fxml"));
            Scene newScene = new Scene(newSceneRoot, 640, 400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        } else if (correct == 1) {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("NoBueno.fxml"));
            Scene newScene = new Scene(newSceneRoot, 640, 400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        } else if (correct == 0) {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("NoBueno2.fxml"));
            Scene newScene = new Scene(newSceneRoot, 640, 400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        }
    }

    //switchPanes
    public void switchPane(String visiblePane) {
        Boolean logIn = false, lessons = false, quiz = false, grades = false, lessonMenu = false, mainMenu = false;
        if (visiblePane.equals("logIn")) {
            logIn = true;
            hamburgerView.setDisable(true);

        }
        if (visiblePane.equals("lessonMenu")) {
            lessonMenu = true;
        }
        if (visiblePane.equals("quiz")) {
            quiz = true;
        }
        if (visiblePane.equals("grades")) {
            grades = true;
        }
        if (visiblePane.equals("lessons")) {
            lessons = true;
        }
        if (visiblePane.equals("mainMenu")) {
            mainMenu = true;
            hamburgerView.setDisable(false);
        }
        lessonPane.setVisible(lessons);
        lessonMenuPane.setVisible(lessonMenu);
        loginPane.setVisible(logIn);
        quizPane.setVisible(quiz);
        gradePane.setVisible(grades);
        mainMenuPane.setVisible(mainMenu);
    }
}
