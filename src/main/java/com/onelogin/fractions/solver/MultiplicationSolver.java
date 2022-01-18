package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class MultiplicationSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {

    boolean anyTermHasMixedFraction = isMixedFraction(firstTerm) || isMixedFraction(secondTerm);

    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    long numerator = simpleFirstTerm.getNumerator() * simpleSecondTerm.getNumerator();
    long denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();

    if (anyTermHasMixedFraction) {
      return convertSimpleToMixedFraction(numerator, denominator);
    }

    return simplifyFraction(null, numerator, denominator);
  }
}
