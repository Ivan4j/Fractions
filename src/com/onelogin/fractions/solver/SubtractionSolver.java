package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class SubtractionSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    int numerator = 1;
    int denominator = 1;

    if (simpleFirstTerm.getDenominator() == simpleSecondTerm.getDenominator()) {
      denominator = simpleFirstTerm.getDenominator();
      numerator = simpleFirstTerm.getNumerator() - simpleSecondTerm.getNumerator();
    } else {
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      int firstMult = simpleFirstTerm.getNumerator() * simpleSecondTerm.getDenominator();
      int secondMult = simpleFirstTerm.getDenominator() * simpleSecondTerm.getNumerator();
      numerator = firstMult - secondMult;
    }

    return convertSimpleToMixedFraction(numerator, denominator);
  }
}
