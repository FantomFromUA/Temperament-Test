package com.example.testtemperament;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class QuestionsSceneControler {
    // Кнопка щоб відповісти на питання
    @FXML
    Button buttonAnswer;
    // RadioButton з відповідю так
    @FXML
    RadioButton radioYes;
    // RadioButton з відповідю ні
    @FXML
    RadioButton radioNo;
    // Label в якому записоно питання
    @FXML
    Label labelQuestion;
    // Label з виведенням номера питання
    @FXML
    Label labelCount;

    @FXML
    Parent root;
    Scene scene;
    Stage stage;

    /**
     * метод щоб зробити кнопку видимою
     * після вибирання відповіді
     */
    @FXML
    public void selectAnswer(){
        buttonAnswer.setDisable(false);
    }

    /**
     * Метод для відповіді на питання
     * @param event за допомогою нього створюю Stage
     * @throws IOException
     */
    @FXML
    public void answerClick(ActionEvent event) throws IOException {
        int numberOfQuestion = QuestionContainer.getAnswerNumber();
        if(numberOfQuestion + 1 > 57){
            QuestionContainer.setAnswerNumber(1);
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResultScene.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            return;
        }
        AnswerCounter.checkAnswer(numberOfQuestion, radioYes.isSelected());
        labelQuestion.setText(QuestionContainer.getNextQuestion());
        labelCount.setText(String.format("%s/57", numberOfQuestion+1));
        buttonAnswer.setDisable(true);
        radioYes.setSelected(false);
        radioNo.setSelected(false);
    }

}
