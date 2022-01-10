package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class DivisionSolver extends Solver {

  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    long numerator = simpleFirstTerm.getNumerator() * simpleSecondTerm.getDenominator();
    long denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getNumerator();

    return convertSimpleToMixedFraction(numerator, denominator);
  }
}
