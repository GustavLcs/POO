package com.triguinho.model;

public class Player {
  private String name;
  private int bet;
  private int acc;

  public Player(String name, int bet, int acc) {
    this.name = name;
    this.bet = bet;
    this.acc = acc;
  }

  public int getBet() {
    return bet;
  }

  public void setBet(int bet) {
    this.bet = bet;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAcc() {
    return acc;
  }

  public void setAcc(int acc) {
    this.acc = acc;
  }
}
