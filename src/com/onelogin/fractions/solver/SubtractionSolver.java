package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class SubtractionSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    long numerator = 1;
    long denominator = 1;

    if (simpleFirstTerm.getDenominator() == simpleSecondTerm.getDenominator()) {
      denominator = simpleFirstTerm.getDenominator();
      numerator = simpleFirstTerm.getNumerator() - simpleSecondTerm.getNumerator();
    } else {
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      long firstMult = simpleFirstTerm.getNumerator() * simpleSecondTerm.getDenominator();
      long secondMult = simpleFirstTerm.getDenominator() * simpleSecondTerm.getNumerator();
      numerator = firstMult - secondMult;
    }

    return convertSimpleToMixedFraction(numerator, denominator);
  }
}
