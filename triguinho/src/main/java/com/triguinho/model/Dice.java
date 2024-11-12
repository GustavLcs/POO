package com.triguinho.model;

public class Dice {
  private int value;

  public int getValue() {
    return value;
  }

  public void girar() {
    value = (int) (Math.random() * 6) + 1;
  }
}