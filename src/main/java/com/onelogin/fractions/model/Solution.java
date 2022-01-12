package com.onelogin.fractions.model;

public class Solution {

  private Fraction solvedEquation;

  public Solution(Fraction solvedEquation) {
    this.solvedEquation = solvedEquation;
  }

  public Fraction getSolvedEquation() {
    return solvedEquation;
  }

  public void setSolvedEquation(Fraction solvedEquation) {
    this.solvedEquation = solvedEquation;
  }

  @Override
  public String toString() {
    return solvedEquation.toString();
  }
}
