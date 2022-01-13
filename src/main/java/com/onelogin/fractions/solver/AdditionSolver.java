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

    if(isNegativeAddition) {
      if (!firstTermHasFraction) {
        simpleFirstTerm = new Fraction(firstTerm.getFullNumber(), 1L);
        firstTerm = simpleFirstTerm;
        firstTermHasFraction = true;
      }

      if (!secondTermHasFraction) {
        simpleSecondTerm = new Fraction(secondTerm.getFullNumber(), 1L);
        secondTerm = simpleSecondTerm;
        secondTermHasFraction = true;
      }
    }

    long numerator = 1;
    long denominator = 1;

    if(firstTermHasFraction && secondTermHasFraction) {
      if (simpleFirstTerm.getDenominator() == simpleSecondTerm.getDenominator()) {
        denominator = simpleFirstTerm.getDenominator();
        numerator = add(simpleFirstTerm.getNumerator(), simpleSecondTerm.getNumerator(), isNegativeAddition);
      } else {
        denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
        numerator = getCrossAddition(simpleFirstTerm, simpleSecondTerm, isNegativeAddition);
      }
      if(firstTerm.getFullNumber() != null || secondTerm.getFullNumber() != null) {
        return convertSimpleToMixedFraction(numerator, denominator);
      }
      return simplifyFraction(null, numerator, denominator);
    }

    if(firstTermHasFraction) {
      numerator = firstTerm.getNumerator();
      denominator = firstTerm.getDenominator();
      long fullNumber = add(firstTerm.getFullNumber(), secondTerm.getFullNumber(), isNegativeAddition);
      return returnProperFraction(fullNumber, numerator, denominator, secondTermHasFraction, !(firstTerm.getFullNumber() != null && secondTerm.getFullNumber() != null));
    }  else if(secondTermHasFraction) {
      numerator = secondTerm.getNumerator();
      denominator = secondTerm.getDenominator();
      long fullNumber = add(firstTerm.getFullNumber(), secondTerm.getFullNumber(), isNegativeAddition);
      return returnProperFraction(fullNumber, numerator, denominator, firstTermHasFraction, !(firstTerm.getFullNumber() != null && secondTerm.getFullNumber() != null));
    } else {
      return new Fraction(
          add(firstTerm.getFullNumber(), secondTerm.getFullNumber(), isNegativeAddition),
          null,
          null);
    }
  }

  private Long add(Long firstNumber, Long secondNumber, boolean isNegativeAddition) {
    if(!hasNull(firstNumber, secondNumber)) {
      if (isNegativeAddition) {
        return firstNumber - secondNumber;
      }
      return firstNumber + secondNumber;
    } else {
      return firstNumber == null ? secondNumber : firstNumber;
    }
  }

  private Fraction returnProperFraction(Long fullNumber, Long numerator, Long denominator, boolean decisionFlag, boolean shouldSimplify) {
    if(decisionFlag) {
      return new Fraction(fullNumber, numerator, denominator);
    } else {
      if(shouldSimplify) {
        return convertMixedToSimpleFraction(new Fraction(fullNumber, numerator, denominator));
      }
    }
    return new Fraction(fullNumber, numerator, denominator);
  }

  private boolean hasNull(Long firstNumber, Long secondNumnber) {
    return (firstNumber == null || secondNumnber == null);
  }

}
