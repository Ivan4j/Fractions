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

  protected Fraction convertToFraction(int numerator, int denominator) {
    if((numerator / denominator) >= 2) {
      // Convert back to Mixed Fraction
      int fullNumber = numerator / denominator;
      int newNumerator = numerator - fullNumber * denominator;
      return new Fraction(fullNumber, newNumerator, denominator);
    } else {
      return new Fraction(numerator, denominator);
    }
  }
}
