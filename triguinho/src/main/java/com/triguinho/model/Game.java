package com.triguinho.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.triguinho.model.dao.SQLConnection;

public class Game {
    private static ObservableList<Player> players = FXCollections.observableArrayList();

    private static ObservableList<Player> playerRanking = FXCollections.observableArrayList(SQLConnection.getPlayers());

    private static Dice dice1 = new Dice();
    private static Dice dice2 = new Dice();
    private static int resultado;
    private static Player winner = null;
    
    public static int getResultado() {
        return resultado;
    }

    public static ObservableList<Player> getPlayers() {
        return players;
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void removePlayer(Player player) {
        players.remove(player);
    }

    public static void clearPlayers() {
        players.clear();
    }

    public static ObservableList<Player> getPlayerRanking() {
        return playerRanking;
    }

    public static Player play() {

        dice1.girar();
        dice2.girar();

        resultado = dice1.getValue() + dice2.getValue();
        
        for (Player player : players) {
            if (player.getBet() == resultado) {
                winner = player;
                break;
            }
        }


        if (winner != null) {
            String name = winner.getName();
            Player p = playerRanking.filtered(player -> player.getName().equals(name)).stream().findFirst().orElse(null);
            if (p == null) {
                p = new Player(name, 0, 1);
                playerRanking.add(p);
                SQLConnection.insertPlayer(p);
            } else {
                p.setAcc(p.getAcc() + 1);
                SQLConnection.updatePlayer(p);
            }

            playerRanking.sort((p1, p2) -> p2.getAcc() - p1.getAcc());

            return p;
        }

        return null;
    }
}