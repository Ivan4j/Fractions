package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class SubtractionSolver extends AdditionSolver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    return solve(firstTerm, secondTerm, true);
  }
}
