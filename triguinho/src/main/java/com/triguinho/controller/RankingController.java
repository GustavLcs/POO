package com.triguinho.controller;

import com.triguinho.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class RankingController {
    @FXML
    private TableView<Player> tableView;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, String> betColumn;

    public void setRanking(ObservableList<Player> players) {
        tableView.setItems(players);

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        betColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAcc())));
    }
}