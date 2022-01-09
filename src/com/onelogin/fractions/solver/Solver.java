package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public abstract class Solver {
  public abstract Fraction solve(Fraction firstTerm, Fraction secondTerm);

  protected Fraction convertMixedToSimpleFraction(Fraction fraction) {
    if(fraction.getFullNumber() != 1) {
      int numerator = fraction.getDenominator() * fraction.getFullNumber() + fraction.getNumerator();
      int denominator = fraction.getDenominator();
      return new Fraction(numerator, denominator);
    }
    return fraction;
  }

  protected Fraction convertSimpleToMixedFraction(int numerator, int denominator) {
    // Use ABS to properly make a division between negative numbers (for subtraction calculation)
    int div = Math.abs(numerator) / Math.abs(denominator);
    if(div >= 2) {
      // Convert back to Mixed Fraction
      int fullNumber = numerator / denominator;
      int newNumerator = Math.abs(numerator - fullNumber * denominator);
      return simplifyFraction(fullNumber, newNumerator, denominator);
    } else {
      return simplifyFraction(1, numerator, denominator);
    }
  }

  protected Fraction simplifyFraction(int fullNumber, int numerator, int denominator) {
    int max = Math.max(numerator, denominator);

    for(int i=2; i<=max; i++) {
      if(numerator % i == 0 && denominator % i == 0) {
        numerator = numerator / i;
        denominator = denominator / i;
      }
    }
    return new Fraction(fullNumber, numerator, denominator);
  }
}
