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
      return new Fraction(fullNumber, newNumerator, denominator);
    } else {
      return new Fraction(numerator, denominator);
    }
  }
}
