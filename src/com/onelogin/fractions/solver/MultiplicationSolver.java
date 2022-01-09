package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class MultiplicationSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    int numerator = 1;
    int denominator = 1;

    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    numerator = simpleFirstTerm.getNumerator() * simpleSecondTerm.getNumerator();
    denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();

    return convertSimpleToMixedFraction(numerator, denominator);
  }
}
