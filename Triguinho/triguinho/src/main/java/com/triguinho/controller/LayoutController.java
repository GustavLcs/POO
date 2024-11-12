package com.triguinho.controller;

import com.triguinho.model.Player;
import com.triguinho.model.Game;
import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class LayoutController {
    @FXML
    private TableView<Player> tableView;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, String> betColumn;

    @FXML
    private TableColumn<Player, Void> actionColumn;

    private ObservableList<Player> players = Game.getPlayers();

    public void initialize() {
        tableView.setItems(players);

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        betColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBet())));

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        betColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        nameColumn.setReorderable(false);
        betColumn.setReorderable(false);
        actionColumn.setReorderable(false);

        nameColumn.setOnEditCommit(event -> {
            Player player = event.getRowValue();
            player.setName(event.getNewValue());
        });

        betColumn.setOnEditCommit(event -> {
            Player player = event.getRowValue();
            player.setBet(Integer.parseInt(event.getNewValue()));
        });

        tableView.setEditable(true);

        actionColumn.setCellFactory(column -> new TableCell<Player, Void>() {
            private final Button button = new Button("Apagar");

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getIndex() >= players.size()) {
                    setGraphic(null);
                } else {
                    button.setOnAction(event -> players.remove(getIndex()));
                    setGraphic(button);
                }
            }
        });
    }

    @FXML
    public void apostar() throws IOException {
        if (players.size() < 2) {
            showAlert("Jogadores Insuficientes", "É necessário ter pelo menos 2 jogadores para apostar.");
            return;
        }
        for (Player p1 : players) {
            if (p1.getBet() < 2 || p1.getBet() > 12) {
                showAlert("Aposta inválida", "O número da aposta precisa estar entre 2 e 12.");
                return;
            }
            for (Player p2 : players) {
                if (p1 != p2 && p1.getName().equals(p2.getName())) {
                    showAlert("Nomes iguais", "Não pode haver nomes iguais.");
                    return;
                }
                if (p1 != p2 && p1.getBet() == p2.getBet()) {
                    showAlert("Apostas iguais", "Não pode haver apostas iguais.");
                    return;
                }
            }
        }

        Player winner = Game.play();
        String result;

        if (winner != null) {
            result = "Jogador " + winner.getName() + " venceu!";
        } else {
            result = "O computador venceu o jogo!";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/result.fxml"));
        Stage stage = (Stage) tableView.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        ResultController controller = loader.getController();
        controller.setResults(result + "(" + Game.getResultado() + ")");
        stage.setScene(scene);
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
    }

    @FXML
    public void adicionarApostador() {
        if (players.size() >= 12) {
            showAlert("Limite de Jogadores", "O número máximo de jogadores é 12.");
            return;
        }
        Player player = new Player("Novo Nome", 0, 0);
        players.add(player);
        tableView.scrollTo(players.size() - 1);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void verRanking() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ranking.fxml"));
        Stage rankingStage = new Stage();
        Scene scene = new Scene(loader.load());

        RankingController rankingController = loader.getController();
        rankingController.setRanking(Game.getPlayerRanking());

        rankingStage.setTitle("Ranking Atual");
        rankingStage.setScene(scene);
        rankingStage.show();
    }
}