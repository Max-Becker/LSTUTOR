package sample;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller extends Main implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML

    public void loginButtonHandler(ActionEvent event) throws Exception{
        Parent newSceneRoot = FXMLLoader.load(getClass().getResource("lesson1.fxml"));
        Scene newScene = new Scene(newSceneRoot);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(newScene);
        window.show();
    }

    public void nextLesson1Handler(ActionEvent event) throws Exception{
        Parent newSceneRoot = FXMLLoader.load(getClass().getResource("lesson2.fxml"));
        Scene newScene = new Scene(newSceneRoot,640,400);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(newScene);
        window.show();
    }

    public void nextLesson2Handler(ActionEvent event) throws Exception{
        Parent newSceneRoot = FXMLLoader.load(getClass().getResource("lesson3.fxml"));
        Scene newScene = new Scene(newSceneRoot,640,400);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(newScene);
        window.show();
    }

    public void nextLesson3Handler(ActionEvent event) throws Exception{
        Parent newSceneRoot = FXMLLoader.load(getClass().getResource("lesson4.fxml"));
        Scene newScene = new Scene(newSceneRoot,640,400);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(newScene);
        window.show();
    }

    public void nextLesson4Handler(ActionEvent event) throws Exception{
        Parent newSceneRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene newScene = new Scene(newSceneRoot,640,400);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(newScene);
        window.show();
    }
    @FXML
    public void questionAnswer(ActionEvent e)
    {
        if(e.getSource()== Q1A)
        {
            answered++;
            Q1B.setDisable(true);
            Q1C.setDisable(true);
        }
        else if(e.getSource()== Q1B)
        {
            answered++;
            Q1A.setDisable(true);
            Q1C.setDisable(true);
        }
        else if(e.getSource()== Q1C)
        {
            answered++;
            Q1B.setDisable(true);
            Q1A.setDisable(true);
        }
        else if(e.getSource()== Q2A)
        {
            answered++;
            Q2B.setDisable(true);
            Q2C.setDisable(true);
        }
        else if(e.getSource()== Q2B)
        {
            answered++;
            Q2A.setDisable(true);
            Q2C.setDisable(true);
        }
        else if(e.getSource()== Q2C)
        {
            answered++;
            Q2B.setDisable(true);
            Q2A.setDisable(true);
        }
        else if(e.getSource()== Q3A)
        {
            answered++;
            Q3B.setDisable(true);
            Q3C.setDisable(true);
        }
        else if(e.getSource()== Q3B)
        {
            answered++;
            Q3A.setDisable(true);
            Q3C.setDisable(true);
        }
        else if(e.getSource()== Q3C)
        {
            answered++;
            Q3B.setDisable(true);
            Q3A.setDisable(true);
        }

    }
    @FXML
    public void submitAllHandler(ActionEvent event) throws Exception
    {
        if(answered >= 3)
        {
            if(!Q1B.isDisabled() && !Q2A.isDisabled() && !Q3B.isDisabled())
            {
                displayReaction(3);
            }
            else if((!Q1B.isDisabled() && !Q2A.isDisabled())||(!Q2A.isDisabled() && !Q3B.isDisabled())|| (!Q1A.isDisabled() && !Q3B.isDisabled()) )
            {
                displayReaction(2);
            }
            else if(!Q1B.isDisabled() || !Q2A.isDisabled() || !Q3B.isDisabled())
            {
                displayReaction(1);
            }
            else
                displayReaction(0);
        }
    }
    @FXML
    public void logoutHandler(ActionEvent actionEvent)
    {
    }
    @FXML
    public void changLessonHandler(ActionEvent actionEvent)
    {
    }
    @FXML
    public void changeAssignmentHandler(ActionEvent actionEvent)
    {
    }
    @FXML
    public void squizzesHandler(ActionEvent actionEvent)
    {
    }
    @FXML
    public void newLesson1Handler(ActionEvent event) throws Exception
    {
        Parent newSceneRoot = FXMLLoader.load(getClass().getResource("lesson1.fxml"));
        Scene newScene = new Scene(newSceneRoot);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(newScene);
        window.show();
    }
    public void displayReaction(int correct) throws Exception
    {
        if(correct == 3)
        {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("GreatJob.fxml"));
            Scene newScene = new Scene(newSceneRoot,640,400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        }
        else if(correct == 2)
        {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("NotQuite.fxml"));
            Scene newScene = new Scene(newSceneRoot,640,400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        }
        else if(correct == 1)
        {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("NoBueno.fxml"));
            Scene newScene = new Scene(newSceneRoot,640,400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        }
        else if(correct == 0 )
        {
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("NoBueno2.fxml"));
            Scene newScene = new Scene(newSceneRoot,640,400);

            Stage window = (Stage) (SubmitAll.getScene().getWindow());
            window.setScene(newScene);
            window.show();
        }
    }
}