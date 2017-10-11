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
import java.util.LinkedList;


public class Controller extends Main implements Initializable {


    //private javafx.scene.control.TextField UsernameField;
    @FXML
    private RadioButton  Q1A;
    @FXML
    private RadioButton  Q1B;
    @FXML
    private RadioButton  Q1C;
    @FXML
    private RadioButton  Q2A;
    @FXML
    private RadioButton  Q2B;
    @FXML
    private RadioButton  Q2C;
    @FXML
    private RadioButton  Q3A;
    @FXML
    private RadioButton  Q3B;
    @FXML
    private RadioButton  Q3C;

    private int answered = 0;
    @FXML
    private Button SubmitAll;
    @FXML
    private TextField UsernameField;
    @FXML
    private PasswordField passfield;






    Image hamburger = new Image("/resources/hamburger.png");
    Image userIcon = new Image("/resources/usericon.png");
    Image logo = new Image("/resources/dsdt.png");
    @FXML
    ImageView hamburgerView = new ImageView();
    @FXML
    ImageView userView = new ImageView();
    @FXML
    ImageView logoView = new ImageView();
    @FXML
    ImageView logoView1 = new ImageView();
    @FXML Label userNameLabel = new Label();


    Lesson lesson = new Lesson(0);

    private  String userInput = null;
    private String passInput = null;
    private Boolean truelogin = false;
    UserList linkedlist = new sample.UserList();
    JFrame frame = new JFrame();



    @FXML
    Pane sideMenuPane, lessonMenuPane, loginPane, gradePane, quizPane, lessonPane, mainMenuPane ,lessonPane2,lessonPane3, lessonPane4= new Pane();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        linkedlist.add(userInput, passInput);
        Alert alert = new Alert((Alert.AlertType.CONFIRMATION));
        alert.setTitle("Confirmed");
        alert.setHeaderText("Account Created");
        alert.showAndWait();
        linkedlist.printUsers();
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

    }

    @FXML
    public void logoutHandler() {
        switchPane("logIn");
    }

    @FXML
    public void lessonMenuHandler() {
        switchPane("lessonMenu");
    }

    //Lessons
    @FXML
    public void productRuleHandler() {
        switchPane("lessons");
        lesson.setLesson(0);
    }

    @FXML
    public void powerRuleHandler() {
        switchPane("lessons");

    }

    @FXML
    public void chainRuleHandler() {
        switchPane("lessons");

    }

    @FXML
    public void exponentRuleHandler() {
        switchPane("lessons");

    }
    @FXML
    public void nextLesson(){

    }

    @FXML
    public void questionAnswer(ActionEvent e) {
        if (e.getSource() == Q1A) {
            answered++;
            Q1B.setDisable(true);
            Q1C.setDisable(true);
        } else if (e.getSource() == Q1B) {
            answered++;
            Q1A.setDisable(true);
            Q1C.setDisable(true);
        } else if (e.getSource() == Q1C) {
            answered++;
            Q1B.setDisable(true);
            Q1A.setDisable(true);
        } else if (e.getSource() == Q2A) {
            answered++;
            Q2B.setDisable(true);
            Q2C.setDisable(true);
        } else if (e.getSource() == Q2B) {
            answered++;
            Q2A.setDisable(true);
            Q2C.setDisable(true);
        } else if (e.getSource() == Q2C) {
            answered++;
            Q2B.setDisable(true);
            Q2A.setDisable(true);
        } else if (e.getSource() == Q3A) {
            answered++;
            Q3B.setDisable(true);
            Q3C.setDisable(true);
        } else if (e.getSource() == Q3B) {
            answered++;
            Q3A.setDisable(true);
            Q3C.setDisable(true);
        } else if (e.getSource() == Q3C) {
            answered++;
            Q3B.setDisable(true);
            Q3A.setDisable(true);
        }

    }

    @FXML
    public void submitAllHandler(ActionEvent event) throws Exception {
        if (answered >= 3) {
            if (!Q1B.isDisabled() && !Q2A.isDisabled() && !Q3B.isDisabled()) {
                displayReaction(3);
            } else if ((!Q1B.isDisabled() && !Q2A.isDisabled()) || (!Q2A.isDisabled() && !Q3B.isDisabled()) || (!Q1A.isDisabled() && !Q3B.isDisabled())) {
                displayReaction(2);
            } else if (!Q1B.isDisabled() || !Q2A.isDisabled() || !Q3B.isDisabled()) {
                displayReaction(1);
            } else
                displayReaction(0);
        }
    }

    @FXML
    public void squizzesHandler(ActionEvent actionEvent) {
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
        }
        lessonPane.setVisible(lessons);
        lessonMenuPane.setVisible(lessonMenu);
        loginPane.setVisible(logIn);
        quizPane.setVisible(quiz);
        gradePane.setVisible(grades);
        mainMenuPane.setVisible(mainMenu);
    }
}
