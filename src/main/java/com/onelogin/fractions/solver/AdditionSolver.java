package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class AdditionSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    return solve(firstTerm, secondTerm, false);
  }

  protected Fraction solve(Fraction firstTerm, Fraction secondTerm, boolean isNegativeAddition) {
    boolean firstTermHasFraction = firstTerm.getNumerator() != null;
    boolean secondTermHasFraction = secondTerm.getNumerator() != null;

    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    long numerator = 1;
    long denominator = 1;

    if(firstTermHasFraction && secondTermHasFraction) {
      if (simpleFirstTerm.getDenominator() == simpleSecondTerm.getDenominator()) {
        denominator = simpleFirstTerm.getDenominator();
        numerator = add(simpleFirstTerm.getNumerator(), simpleSecondTerm.getNumerator(), isNegativeAddition);
      } else {
        denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
        numerator = getCrossAddition(simpleFirstTerm, simpleSecondTerm);
      }
    } else if(firstTermHasFraction) {
      numerator = firstTerm.getNumerator();
      denominator = firstTerm.getDenominator();
      long fullNumber = add(firstTerm.getFullNumber(), secondTerm.getFullNumber(), isNegativeAddition);
      return new Fraction(fullNumber, numerator, denominator);
    }  else if(secondTermHasFraction) {
      numerator = secondTerm.getNumerator();
      denominator = secondTerm.getDenominator();
      long fullNumber = add(firstTerm.getFullNumber(), secondTerm.getFullNumber(), isNegativeAddition);
      return new Fraction(fullNumber, numerator, denominator);
    } else {
      return new Fraction(
          add(firstTerm.getFullNumber(), secondTerm.getFullNumber(), isNegativeAddition),
          null,
          null);
    }

    if(firstTerm.getFullNumber() != null || secondTerm.getFullNumber() != null) {
      return convertSimpleToMixedFraction(numerator, denominator);
    }

    //return new Fraction(numerator, denominator);
    return simplifyFraction(null, numerator, denominator);
  }

  protected Long add(Long firstNumber, Long secondNumber, boolean isNegativeAddition) {
    if(isNegativeAddition) {
      return firstNumber - secondNumber;
    }
    return firstNumber + secondNumber;
  }

}
