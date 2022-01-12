package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class MultiplicationSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {

    boolean firstTermHasFraction = firstTerm.getNumerator() != null;
    boolean secondTermHasFraction = secondTerm.getNumerator() != null;

    long numerator = 1;
    long denominator = 1;

    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    if(firstTermHasFraction && secondTermHasFraction) {

      numerator = simpleFirstTerm.getNumerator() * simpleSecondTerm.getNumerator();
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();

    } else if(firstTermHasFraction ) {

      numerator = secondTerm.getFullNumber() * firstTerm.getNumerator();
      denominator = firstTerm.getDenominator();
      return new Fraction(null, numerator, denominator);
    } else if(secondTermHasFraction ) {

      numerator = firstTerm.getFullNumber() * secondTerm.getNumerator();
      denominator = secondTerm.getDenominator();
      return new Fraction(null, numerator, denominator);
    } else {
      return new Fraction(firstTerm.getFullNumber() * secondTerm.getFullNumber(), null, null);
    }

    if(firstTerm.getFullNumber() != null || secondTerm.getFullNumber() != null) {
      return convertSimpleToMixedFraction(numerator, denominator);
    }

    return simplifyFraction(null, numerator, denominator);
  }
}
