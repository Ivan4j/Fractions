package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class DivisionSolver extends Solver {

  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    boolean firstTermHasFraction = firstTerm.getNumerator() != null;
    boolean secondTermHasFraction = secondTerm.getNumerator() != null;

    long numerator = 1;
    long denominator = 1;

    if(firstTermHasFraction && secondTermHasFraction) {
      Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
      Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);
      numerator = simpleFirstTerm.getNumerator() * simpleSecondTerm.getDenominator();
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getNumerator();
    } else if(firstTermHasFraction) {
      numerator = firstTerm.getNumerator();
      denominator = firstTerm.getDenominator() * secondTerm.getFullNumber();
    } else if(secondTermHasFraction) {
      numerator = firstTerm.getFullNumber() * secondTerm.getDenominator();
      denominator = secondTerm.getNumerator();
    }

    if(firstTerm.getFullNumber() != null || secondTerm.getFullNumber() != null) {
      return convertSimpleToMixedFraction(numerator, denominator);
    }

    return simplifyFraction(null, numerator, denominator);
  }
}
