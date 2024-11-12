package com.triguinho.model.dao;

import com.triguinho.model.Player;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLConnection {
    private static final String URL = "jdbc:sqlite:triguinho.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void prepare() {
        String sql = "CREATE TABLE IF NOT EXISTS players (id INTEGER PRIMARY KEY, name TEXT NOT NULL, bet INTEGER NOT NULL)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void insertPlayer(Player player) {
        String sql = "INSERT INTO players(name, bet) VALUES(?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getAcc());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT name, bet FROM players";
        
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                players.add(new Player(rs.getString("name"), 0, rs.getInt("bet")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        players.sort((p1, p2) -> p2.getAcc() - p1.getAcc());
        return players;
    }

    public static void updatePlayer(Player player) {
      String sql = "UPDATE players SET bet = ? WHERE name = ?";
      try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
          pstmt.setInt(1, player.getAcc());
          pstmt.setString(2, player.getName());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          System.err.println(e.getMessage());
      }
  }
}