package com.onelogin.fractions.model;

/**
 * Valid operators
 */
public enum Operator {
  ADD("+"),
  SUB("-"),
  MULT("*"),
  DIV("/");

  private String symbol;

  Operator(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}
