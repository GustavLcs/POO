package com.triguinho;
import com.triguinho.model.dao.SQLConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent MainScreen = FXMLLoader.load(getClass().getResource("/MainScreen.fxml"));
        primaryStage.setTitle("Triguinho");
        primaryStage.setScene(new Scene(MainScreen));
        primaryStage.setWidth(610);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

    public static void main(String[] args) {
        SQLConnection.prepare();
        launch(args);
    }
}