package com.triguinho.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController {
  @FXML
  private Button playButton;
  @FXML
  private Button exitButton;
  
  @FXML
  private void switchLayout() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
    Stage stage = (Stage) playButton.getScene().getWindow();
    Scene scene = new Scene(loader.load(), stage.getWidth(), stage.getHeight());
    stage.setScene(scene);
  }

  @FXML
  private void closeAll() throws IOException {
    Stage stage = (Stage) exitButton.getScene().getWindow();
    stage.close();
  }
}
