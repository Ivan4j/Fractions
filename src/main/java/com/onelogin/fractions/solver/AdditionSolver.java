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
      numerator = add(numerator, simpleSecondTerm.getNumerator(), isNegativeAddition);
    } else if (simpleSecondTerm.getDenominator() == 1) {
      numerator = simpleSecondTerm.getNumerator() * simpleFirstTerm.getDenominator();
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      numerator = add(simpleFirstTerm.getNumerator(), numerator, isNegativeAddition);
    } else {
      denominator = simpleFirstTerm.getDenominator() * simpleSecondTerm.getDenominator();
      numerator = getCrossAddition(simpleFirstTerm, simpleSecondTerm, isNegativeAddition);
    }

    // Convert to a Mixed fraction if any of the original terms is mixed as well
    if (anyTermHasMixedFraction) {
      return convertSimpleToMixedFraction(numerator, denominator);
    }

    return simplifyFraction(null, numerator, denominator);
  }

  /**
   * Perform positive or negative addition between two numbers
   * @param firstNumber
   * @param secondNumber
   * @param isNegativeAddition this indicates if the numbers will be added or subtracted
   * @return
   */
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
