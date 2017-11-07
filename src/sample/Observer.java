package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.fxml.FXML;
import java.util.*;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;

import javax.swing.*;
//import java.awt.;
import java.net.URL;
import java.util.ResourceBundle;


public class Observer {
    @FXML ImageView Qreaction = new ImageView();
    @FXML Image worry = new Image("/resources/WorryIcon.png");
    @FXML Image sorry = new Image("/resources/SorryIcon.png");
    @FXML Image happy = new Image("/resources/HappyIcon.png");
    public void Observer(int single)
    {

    }
    @FXML public void setImage(int single){
        int status = single;

        switch (status)
        {
            case 1:
                Qreaction.setImage(sorry);
                break;

            case 2:
                Qreaction.setImage(worry);
                break;

            case 3:
                Qreaction.setImage(happy);
                break;
        }


    }


}
