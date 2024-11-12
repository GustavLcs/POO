package com.triguinho.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultController {
    @FXML
    private Label resultLabel;

    public void setResults(String result) {
        resultLabel.setText("Resultado: " + result);
    }

    @FXML
    public void handlePlayAgain() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
        Stage stage = (Stage) resultLabel.getScene().getWindow();
        Scene scene = new Scene(loader.load(), stage.getWidth(), stage.getHeight());
        stage.setScene(scene);
    }
}
