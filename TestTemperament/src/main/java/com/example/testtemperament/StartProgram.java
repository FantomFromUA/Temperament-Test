package com.example.testtemperament;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartProgram extends Application {
    /**
     * Запуск програми
     * @param stage головний Stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartProgram.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ReadQuestions.ReadQuestions();
        AnswerCounter.fillAnswers();
    }

    public static void main(String[] args) {
        launch();
    }
}