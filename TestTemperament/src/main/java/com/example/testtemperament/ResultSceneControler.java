package com.example.testtemperament;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.awt.Desktop;

public class ResultSceneControler implements Initializable {
    // Label з результатом
    @FXML
    Label labelResult;
    // Label з силкою на визначення темпераменту
    @FXML
    Label labelLink;
    // Label з вивідом колькості неправдивих відповідей
    @FXML
    Label labelLie;

    @FXML
    Parent root;
    Scene scene;
    Stage stage;

    /**
     * Метод для задання початкових значень сцени
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelResult.setText(AnswerCounter.getResult());
        labelLie.setText(String.format("Кількість неправдивих відповідей: %s, %s", AnswerCounter.getCountLie(), AnswerCounter.checkLie()));
    }

    /**
     * Метод для переходу на сайт з вижначенням темпераменту (по натисканню по labelLink)
     */
    @FXML
    public void goToSite(){
        try {
            Desktop.getDesktop().browse(new URI(AnswerCounter.getUrlInfo()));
        } catch (URISyntaxException | IOException ex) {

        }
    }

    /**
     * Метод для проходження тесту заново
     * @param event за допомогою нього створюю Stage
     * @throws IOException
     */
    @FXML
    public void onMoreTime(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("QuestionsScene.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        AnswerCounter.recetAll();
    }
}
