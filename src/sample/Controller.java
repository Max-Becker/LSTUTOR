package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaViewBuilder;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.*;
import javafx.fxml.FXML;
import java.util.*;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javax.swing.*;
//import java.awt.;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import java.io.*;



public class Controller extends Main implements Initializable {
    int i = 0;
    private MediaView mediaview;
    @FXML
    private Button SubmitAll, hintButton;
    @FXML
    private TextField UsernameField, newPassField;
    @FXML
    private PasswordField passfield;
    @FXML
    ImageView hamburgerView = new ImageView();
    @FXML
    ImageView userView = new ImageView();
    @FXML
    ImageView logoView = new ImageView();
    @FXML
    ImageView logoView1 = new ImageView();
    @FXML
    Label userNameLabel = new Label();
    @FXML
    ImageView lessonImage = new ImageView();
    @FXML
    ImageView question1 = new ImageView();
    @FXML
    ImageView question2 = new ImageView();
    @FXML
    ImageView question3 = new ImageView();
    @FXML
    ImageView questionimg = new ImageView();
    @FXML
    ImageView Qreaction = new ImageView();
    @FXML
    Image worry = new Image("/resources/WorryIcon.png");
    @FXML
    Image sorry = new Image("/resources/SorryIcon.png");
    @FXML
    Image happy = new Image("/resources/HappyIcon.png");
    @FXML
    Label lessonTitle, labelLesson, labelLesson1, labelLesson2, labelLesson3, quizGradeLabel, totalGrade, emojiresponse = new Label();
    @FXML Pane sideMenuPane, lessonMenuPane, loginPane, gradePane, quizPane, lessonPane, mainMenuPane, modalBox, darkBGPane, settingPane, newPasswordPane = new Pane();
    @FXML
    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
    private String userInput = null;
    private String passInput = null;
    private String newPassInput = null;
    private Boolean truelogin = false;
    private ToggleGroup group = new ToggleGroup();
    private ToggleGroup quizGroup = new ToggleGroup();
    @FXML
    RadioButton Q1A1, Q1A11, Q1A12, Q1B1, Q1B11, Q1B12, Q1C1, Q1C11, Q1C12;
    @FXML
    RadioButton QuizA, QuizB, QuizC;
    UserList linkedlist = new sample.UserList();
    ReadandWrite getData = new ReadandWrite();
    ReadandWrite store = new ReadandWrite();
    JFrame frame = new JFrame();
    int lessonState = 0;
    int previousQuestion;
    char[] answers = new char[3];
    char[] userAnswers = new char[3];
    private int grade1 = 0, grade2 = 0, grade3 = 0, grade4 = 0, gradeQuiz = 0;
    Image hamburger = new Image("/resources/hamburger.png");
    Image userIcon = new Image("/resources/usericon.png");
    Image logo = new Image("/resources/dsdt.png");
    private char UserInput[];
    char userQuizAnswer;
    int quizcount = 0;
    char quizAnswer;
    Quiz quiz = new sample.Quiz();
    ControlCenter c = ControlCenter.getControl();
    Observer o = new sample.Observer();
    long startTime, endTime, totalTime;
    int incount = 0;
    long[] totTime = new long[3];
    int quizQuestion = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // getData.readfromFile();
        hamburgerView.setImage(hamburger);
        userView.setImage(userIcon);
        logoView.setImage(logo);
        logoView1.setImage(logo);
        Qreaction.setImage(happy);
        switchPane("logIn");
        Q1A1.setToggleGroup(group);
        Q1A11.setToggleGroup(group);
        Q1A12.setToggleGroup(group);
        Q1B1.setToggleGroup(group);
        Q1B11.setToggleGroup(group);
        Q1B12.setToggleGroup(group);
        Q1C1.setToggleGroup(group);
        Q1C11.setToggleGroup(group);
        Q1C12.setToggleGroup(group);
        QuizA.setToggleGroup(quizGroup);
        QuizB.setToggleGroup(quizGroup);
        QuizC.setToggleGroup(quizGroup);
    }

    @FXML

    public void loginButtonHandler(ActionEvent event) throws Exception
    {
        userInput = UsernameField.getText();
        passInput = passfield.getText();
        store.readfromFile();
        int empty = 1;
        node temp;
        int login = store.search(userInput, passInput);
        if(userInput.isEmpty() == true || passInput.isEmpty() == true)
        {
            empty = 0;
        }
        if(empty == 0)
        {
            Alert error = new Alert((Alert.AlertType.CONFIRMATION));
            error.setTitle("Error");
            error.setHeaderText("No Username or Password Entered");
            error.showAndWait();
        }

        else if(login == 0 && empty != 0)
        {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("Users");
            alert.setHeaderText("No accounts registered");
            alert.showAndWait();
        }
        else if(login == 2|| login == 1) {

            temp = store.getNode();
            while (temp != null)
            {
                if (temp.userName.equals(userInput))
                {
                    if (temp.password.equals(passInput)) {
                        truelogin = true;
                        userNameLabel.setText(temp.userName);
                        switchPane("mainMenu");
                    }

                }
                else if( login == 1 )
                {
                    Alert alert = new Alert((Alert.AlertType.ERROR));
                    alert.setTitle("Account Not Found");
                    alert.setHeaderText("Incorrect Password");
                    alert.showAndWait();
                    break;

                }

                temp = temp.next;
            }
            truelogin = false;


        }
        else if(truelogin == false)
        {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("Found?");
            alert.setHeaderText("Account not found");
            alert.showAndWait();
        }


    }


    public void createAccountHandler() throws Exception {
        userInput = UsernameField.getText();
        passInput = passfield.getText();
        int created = store.search(userInput, passInput);
        if (userInput.isEmpty() == true || passInput.isEmpty() == true) {
            Alert error = new Alert((Alert.AlertType.CONFIRMATION));
            error.setTitle("Error");
            error.setHeaderText("No Username or Password Entered");
            error.showAndWait();
        } else {

            if (created == 1 || created == 2) {
                Alert notify = new Alert((Alert.AlertType.CONFIRMATION));
                notify.setTitle("Error");
                notify.setHeaderText("User Already Exists");
                notify.showAndWait();
            }
            if (created == 0 || created == 3) {
                //store.add(userInput, passInput, grade1, grade2, grade3, grade4, gradeQuiz);
                Alert first = new Alert((Alert.AlertType.CONFIRMATION));
                first.setTitle("Confirmed");
                first.setHeaderText("Account Created");
                first.showAndWait();
                store.printUsers();
                store.writeToFile(userInput, passInput, grade1, grade2, grade3, grade4, gradeQuiz);
            }


        }

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
        quizQuestion = 1;
        previousQuestion = 1;
        quiz.setQuiz(quizQuestion);
        quizAnswer = quiz.getQuizAnswer();
        questionimg.setImage(quiz.getQuizImage());
    }

    @FXML
    public void gradeHandler() {
        switchPane("grades");
        labelLesson.setText(Double.toString((double) grade1 * 100 / 3));
        labelLesson1.setText(Double.toString((double) grade2 * 100 / 3));
        String grade3String = Double.toString((double) grade3 * 100 / 3);

        labelLesson2.setText(Double.toString((double) grade3 * 100 / 3));
        String grade4String = Double.toString((double) grade4 * 100 / 3);
        labelLesson3.setText(grade4String);
        quizGradeLabel.setText(Double.toString((double) gradeQuiz));
        double gradetot = (((double) grade1 * 100 / 3 + (double) grade2 * 100 / 3 + (double) grade3 * 100 / 3 +
                (double) grade4 * 100 / 3) / 4 * .5 + (double) gradeQuiz * 100 / 10 * .5);
        totalGrade.setText(Double.toString(gradetot));
    }

    @FXML
    public void logoutHandler() {

        switchPane("logIn");
        node temp = store.getNode();
        store.emptyFile();
        while(temp!=null)
        {
                store.overwrite(temp.userName, temp.password, temp.gradeL1, temp.gradeL2, temp.gradeL3, temp.gradeL4, temp.gradeQuiz);
                temp = temp.next;
        }

    }

    @FXML
    public void lessonMenuHandler() {
        switchPane("lessonMenu");
    }

    @FXML
    public void Q1A() {
        userAnswers[0] = 'a';
    }

    @FXML
    public void Q1B() {
        userAnswers[0] = 'b';
    }

    @FXML
    public void Q1C() {
        userAnswers[0] = 'c';
    }
    @FXML public void Q2A(){ userAnswers[1] = 'a';}
    @FXML public void Q2B(){userAnswers[1] = 'b';}
    @FXML public void Q2C(){userAnswers[1] = 'c';}
    @FXML public void Q3A(){ userAnswers[2] = 'a';}
    @FXML public void Q3B(){userAnswers[2] = 'b';}
    @FXML public void Q3C(){userAnswers[2] = 'c';}


    @FXML
    public void QuizA() {
        userQuizAnswer = 'a';
    }

    @FXML
    public void QuizB() {
        userQuizAnswer = 'b';
    }

    @FXML
    public void QuizC() {
        userQuizAnswer = 'c';
    }


    //Lessons
    @FXML public void submitQ1ButtonHandler() throws Exception {
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        totTime[0] = totalTime;

    }
    @FXML public void submitQ2ButtonHandler() throws Exception {
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        totTime[1] = totalTime;

    }
    @FXML public void submitQ3ButtonHandler() throws Exception {
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        totTime[2] = totalTime;

    }

    @FXML
    public void closeModalHandler() throws Exception {
        hintButton.setVisible(false);
        modalBox.setVisible(false);
        darkBGPane.setVisible(false);
    }

    @FXML
    public void hintButton() throws Exception {
        //case for product
        if (previousQuestion == 3 || previousQuestion == 10) {

            final Stage dialog = new Stage();
            final WebView webView = new WebView();
            WebEngine displayVideo = webView.getEngine();
            Button exit = new Button("Exit Video");
            displayVideo.loadContent("<iframe width=\"607\" height=\"342\" src=\"https://www.youtube.com/embed/79ngr0Bur38\" frameborder=\"0\" gesture=\"media\" allowfullscreen></iframe>");
            VBox dialogVbox = new VBox(10);
            Scene dialogScene = new Scene(dialogVbox, 700, 480);
            dialog.setResizable(false);
            dialogVbox.getChildren().addAll(webView, exit);
            exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    webView.getEngine().load(null);
                    dialog.close();
                }
            });
            dialog.setScene(dialogScene);
            dialog.show();

        }
        //case for Chain
        else if (previousQuestion == 1 || previousQuestion == 2 || previousQuestion == 6 || previousQuestion == 8 || previousQuestion == 9) {
            final Stage dialog2 = new Stage();
            final WebView webView2 = new WebView();
            WebEngine displayVideo = webView2.getEngine();
            displayVideo.loadContent("<iframe width=\"705\" height=\"397\" src=\"https://www.youtube.com/embed/MKWBx78L7Qg\" frameborder=\"0\" gesture=\"media\" allowfullscreen></iframe>");
            VBox dialogVbox2 = new VBox(10);
            Scene dialogScene = new Scene(dialogVbox2, 700, 480);
            dialog2.setResizable(false);
            dialog2.setScene(dialogScene);
            Button exit2 = new Button("Exit Video");
            dialogVbox2.getChildren().addAll(webView2, exit2);
            exit2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    webView2.getEngine().load(null);
                    dialog2.close();
                }
            });
            dialog2.setScene(dialogScene);
            dialog2.show();

        }
        //case for Power
        else if (previousQuestion == 4 || previousQuestion == 7) {
            final Stage dialog3 = new Stage();
            final WebView webView3 = new WebView();
            WebEngine displayVideo = webView3.getEngine();
            displayVideo.loadContent("<iframe width=\"705\" height=\"397\" src=\"https://www.youtube.com/embed/bRZmfc1YFsQ\" frameborder=\"0\" gesture=\"media\" allowfullscreen></iframe>");
            VBox dialogVbox3 = new VBox(10);
            Scene dialogScene = new Scene(dialogVbox3, 700, 480);
            dialog3.setResizable(false);
            dialog3.setScene(dialogScene);
            Button exit3 = new Button("Exit Video");
            dialogVbox3.getChildren().addAll(webView3, exit3);
            exit3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    webView3.getEngine().load(null);
                    dialog3.close();
                }
            });
            dialog3.setScene(dialogScene);
            dialog3.show();

        }
        //Case for exponential
        else if (previousQuestion == 5) {
            final Stage dialog4 = new Stage();
            final WebView webView4 = new WebView();
            WebEngine displayVideo = webView4.getEngine();
            displayVideo.loadContent("<iframe width=\"705\" height=\"397\" src=\"https://www.youtube.com/embed/W_gNAjWWvBg\" frameborder=\"0\" gesture=\"media\" allowfullscreen></iframe>");
            VBox dialogVbox4 = new VBox(10);
            Scene dialogScene = new Scene(dialogVbox4, 700, 480);
            dialog4.setResizable(false);
            dialog4.setScene(dialogScene);
            Button exit4 = new Button("Exit Video");
            dialogVbox4.getChildren().addAll(webView4, exit4);
            exit4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    webView4.getEngine().load(null);
                    dialog4.close();
                }
            });
            dialog4.setScene(dialogScene);
            dialog4.show();

        }

    }

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
        hintButton.setVisible(false);

    }

    public void productRuleSubmit() throws Exception
    {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade2 = count;

        incount = 3 - count;
        c.setCorrect(count,lessonState);
        c.setIncorrectAns(incount,lessonState);
        totalTime = 0;
        for (int j = 0; j <3 ; j++) {
            totalTime += totTime[j];
        }
        totalTime =  (totalTime / 3)/1000;
        int totTime = Math.round(totalTime);
        c.setTime(totTime, lessonState);
        o.setImage((int)c.getState(lessonState));
        emojiresponse.setText(o.getEmojiresponse());
        Qreaction.setImage(o.getQreaction());

    }


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
        startTime = System.currentTimeMillis();
        hintButton.setVisible(false);


    }

    public void powerRuleSubmit() throws Exception {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade1 = count;

        incount = 3 - count;
        c.setCorrect(count,lessonState);
        c.setIncorrectAns(incount,lessonState);
        totalTime = 0;
        for (int j = 0; j <3 ; j++) {
            totalTime += totTime[j];
        }
        totalTime =  (totalTime / 3)/1000;
        int totTime = Math.round(totalTime);
        c.setTime(totTime, lessonState);
        o.setImage((int)c.getState(lessonState));
        emojiresponse.setText(o.getEmojiresponse());
        Qreaction.setImage(o.getQreaction());


    }


    public void chainRuleHandler() {
        switchPane("lessons");
        Lesson lesson3 = new Lesson(3);
        lessonImage.setImage(lesson3.getLessonImage());
        Image[] imgArray = lesson3.getQuestionImages();
        question1.setImage(imgArray[0]);
        question2.setImage(imgArray[1]);
        question3.setImage(imgArray[2]);
        lessonState = 3;
        answers = lesson3.getAnswers();
        lessonTitle.setText("Chain Rule");
        hintButton.setVisible(false);

    }

    public void chainRuleSubmit() throws Exception { int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade3 = count;

        incount = 3 - count;
        c.setCorrect(count,lessonState);
        c.setIncorrectAns(incount,lessonState);
        totalTime = 0;
        for (int j = 0; j <3 ; j++) {
            totalTime += totTime[j];
        }
        totalTime =  (totalTime / 3)/1000;
        int totTime = Math.round(totalTime);
        c.setTime(totTime, lessonState);
        o.setImage((int)c.getState(lessonState));
        emojiresponse.setText(o.getEmojiresponse());
        Qreaction.setImage(o.getQreaction());

    }


    public void exponentRuleHandler() {
        switchPane("lessons");
        Lesson lesson4 = new Lesson(4);
        lessonImage.setImage(lesson4.getLessonImage());
        Image[] imgArray = lesson4.getQuestionImages();
        question1.setImage(imgArray[0]);
        question2.setImage(imgArray[1]);
        question3.setImage(imgArray[2]);
        lessonState = 4;
        answers = lesson4.getAnswers();
        lessonTitle.setText("Exponential Rule");
        hintButton.setVisible(false);
    }

    @FXML
    public void nextQuizQuestion() {
        emojiresponse.setVisible(true);


        if (quizQuestion == 10) {
            switchPane("mainMenu");
            if (gradeQuiz >= 8) {
                Qreaction.setImage(happy);
                emojiresponse.setText("Great Job "+userInput+"!!!");
            }
            if (gradeQuiz >= 5 && gradeQuiz < 8) {
                Qreaction.setImage(sorry);
                emojiresponse.setText("Nice "+userInput+"!!!");
            }
            if (gradeQuiz >= 3 && gradeQuiz < 5) {
                Qreaction.setImage(worry);
                emojiresponse.setText("Better Luck Next Time "+userInput);
            }
            if (gradeQuiz >= 0 && gradeQuiz < 3) {
                Qreaction.setImage(worry);
                emojiresponse.setText("Not Good "+userInput+"!");
            }
            store.add(userInput,passInput,grade1,grade2,grade3,grade4,gradeQuiz);

        }
        else if (quizQuestion == 1)
        {
            if (userQuizAnswer == quizAnswer) {
                quizQuestion++;
                quizcount++;
                Qreaction.setImage(happy);
                emojiresponse.setText("Great Job " + userInput + "!!!!");
                hintButton.setVisible(false);
            } else if (userQuizAnswer != quizAnswer) {
                int randomNum = 1 + (int) (Math.random() * 2);
                if (randomNum == 1) {
                    Qreaction.setImage(worry);
                    emojiresponse.setText("Need any help?");
                    hintButton.setVisible(true);

                } else {
                    Qreaction.setImage(sorry);
                    emojiresponse.setText("Supplemental material?");
                    hintButton.setVisible(true);
                }
                quizQuestion++;
            }

            quiz.setQuiz(quizQuestion);
            quizAnswer = quiz.getQuizAnswer();
            questionimg.setImage(quiz.getQuizImage());
        }

        else{

            if (userQuizAnswer == quizAnswer) {
                quizcount++;
                Qreaction.setImage(happy);
                emojiresponse.setText("Great Job " + userInput + "!!!!");
                hintButton.setVisible(false);
            }
            else if (userQuizAnswer != quizAnswer) {

                int randomNum = 1 + (int) (Math.random() * 2);
                if (randomNum == 1) {
                    Qreaction.setImage(worry);
                    emojiresponse.setText("Need any help?");
                    hintButton.setVisible(true);
                } else {
                    Qreaction.setImage(sorry);
                    emojiresponse.setText("Supplemental material?");
                    hintButton.setVisible(true);
                }

            }

            quizQuestion++;
            previousQuestion=quizQuestion-1;
            quiz.setQuiz(quizQuestion);
            quizAnswer = quiz.getQuizAnswer();
            questionimg.setImage(quiz.getQuizImage());
        }
        modalBox.setVisible(true);
        darkBGPane.setVisible(true);
        gradeQuiz = quizcount;
    }


     public void exponentRuleSubmit() throws Exception {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if(userAnswers[i] == answers[i])
            {
                count++;
            }
        }
        grade4 = count;

        incount = 3 - count;
        c.setCorrect(count,lessonState);
        c.setIncorrectAns(incount,lessonState);
        totalTime = 0;
        for (int j = 0; j <3 ; j++) {
            totalTime += totTime[j];
        }
        totalTime =  (totalTime / 3)/1000;
        int totTime = Math.round(totalTime);
        c.setTime(totTime, lessonState);
        o.setImage((int)c.getState(lessonState));
        emojiresponse.setText(o.getEmojiresponse());
        Qreaction.setImage(o.getQreaction());


    }

    @FXML
    public void nextLesson() throws Exception {
        switch(lessonState)
        {
            case 1:powerRuleSubmit();
                modalBox.setVisible(true);
                darkBGPane.setVisible(true);
                productRuleHandler();
                break;
            case 2: productRuleSubmit();
                modalBox.setVisible(true);
                darkBGPane.setVisible(true);
                chainRuleHandler();
                break;
            case 3: chainRuleSubmit();
                modalBox.setVisible(true);
                darkBGPane.setVisible(true);
                exponentRuleHandler();
                break;
            case 4: exponentRuleSubmit();
                modalBox.setVisible(true);
                darkBGPane.setVisible(true);
                switchPane("mainMenu");
                flag4 = true;
                quizPane.setDisable(false);
                break;

        }
    }

    public void switchPane(String visiblePane) {
        sideMenuPane.setVisible(false);
        Boolean logIn = false, lessons = false, quiz = false, grades = false, lessonMenu = false, mainMenu = false, settings = false, newPassword = false;

        if (visiblePane.equals("logIn")) {
            logIn = true;
            hamburgerView.setDisable(true);

        }
        if (visiblePane.equals("lessonMenu")) {
            lessonMenu = true;
        }
        if (visiblePane.equals("quiz")) {


            if (flag4 == false)
            {
                quiz = false;
                mainMenu = true;
            }
            else{quiz = true;}
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
        if (visiblePane.equals("settings")) {
            settings = true;
        }
        if (visiblePane.equals("newPassPane")) {
            newPassword = true;
        }
        lessonPane.setVisible(lessons);
        lessonMenuPane.setVisible(lessonMenu);
        loginPane.setVisible(logIn);
        quizPane.setVisible(quiz);
        gradePane.setVisible(grades);
        mainMenuPane.setVisible(mainMenu);
        settingPane.setVisible(settings);
        newPasswordPane.setVisible(newPassword);
    }



    @FXML
    public void changeImageButtonHandler() {
        Stage secondaryStage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(secondaryStage);
        if (file != null) {
            userView.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    public void changePasswordButtonHandler() {
        switchPane("newPassPane");
    }

    @FXML
    public void settingHandler() {
        switchPane("settings");
    }

    public void Q2A(ActionEvent actionEvent) {
    }

    @FXML
    public void setButtonHandler() {
        userInput = UsernameField.getText();
        newPassInput = newPassField.getText();
        //store.changepass(userInput, newPassInput);
        store.writeToFile(userInput, newPassInput, grade1, grade2, grade3, grade4, gradeQuiz);

        Alert error = new Alert((Alert.AlertType.CONFIRMATION));
        error.setTitle("Success");
        error.setHeaderText("Password Updated");
        error.showAndWait();
    }
}
