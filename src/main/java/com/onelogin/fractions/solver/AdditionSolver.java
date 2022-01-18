package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public class AdditionSolver extends Solver {
  @Override
  public Fraction solve(Fraction firstTerm, Fraction secondTerm) {
    return solve(firstTerm, secondTerm, false);
  }
  protected Fraction solve(Fraction firstTerm, Fraction secondTerm, boolean isNegativeAddition) {
    boolean anyTermHasMixedFraction = isMixedFraction(firstTerm) || isMixedFraction(secondTerm);

    Fraction simpleFirstTerm = convertMixedToSimpleFraction(firstTerm);
    Fraction simpleSecondTerm = convertMixedToSimpleFraction(secondTerm);

    long numerator = 0;
    long denominator = 0;

    if (simpleFirstTerm.getDenominator() == simpleSecondTerm.getDenominator()) {
      denominator = Math.max(simpleFirstTerm.getDenominator(), simpleSecondTerm.getDenominator());
      numerator = add(simpleFirstTerm.getNumerator(), simpleSecondTerm.getNumerator(), isNegativeAddition);
    } else if (simpleFirstTerm.getDenominator() == 1) {
      numerator = simpleFirstTerm.getNumerator() * simpleSecondTerm.getDenominator();
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      if(isNegativeAddition) {
        numerator = numerator - simpleSecondTerm.getNumerator();
      } else {
        numerator = numerator + simpleSecondTerm.getNumerator();
      }
    } else if (simpleSecondTerm.getDenominator() == 1) {
      numerator = simpleSecondTerm.getNumerator() * simpleFirstTerm.getDenominator();
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      if(isNegativeAddition) {
        numerator = simpleFirstTerm.getNumerator() - numerator;
      } else {
        numerator = simpleFirstTerm.getNumerator() + numerator;
      }
    } else {
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      numerator = getCrossAddition(simpleFirstTerm, simpleSecondTerm, isNegativeAddition);
    }

    if (anyTermHasMixedFraction) {
      return convertSimpleToMixedFraction(numerator, denominator);
    }

    return simplifyFraction(null, numerator, denominator);
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

  private boolean hasNull(Long firstNumber, Long secondNumnber) {
    return (firstNumber == null || secondNumnber == null);
  }

}
