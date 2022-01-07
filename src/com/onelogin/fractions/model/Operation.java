package com.onelogin.fractions.model;

import java.util.List;

/**
 * Representation of an Equation
 * Two or more terms can exist for the same equation
 * E.g.: 3_1/2 + 2_7/8 * 3_2/3
 */
public class Operation {
  private List<Fraction> fractions;
  private List<Operator> operators;

  public Operation(List<Fraction> fractions, List<Operator> operators) {
    this.fractions = fractions;
    this.operators = operators;
  }

  public List<Fraction> getFractions() {
    return fractions;
  }

  public void setFractions(List<Fraction> fractions) {
    this.fractions = fractions;
  }

  public List<Operator> getOperators() {
    return operators;
  }

  public void setOperators(List<Operator> operators) {
    this.operators = operators;
  }
}
