package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public abstract class Solver {

  public abstract Fraction solve(Fraction firstTerm, Fraction secondTerm);

  protected Fraction convertMixedToSimpleFraction(Fraction fraction) {
    if(fraction.getFullNumber() != 1) {
      long numerator = fraction.getDenominator() * fraction.getFullNumber() + fraction.getNumerator();
      long denominator = fraction.getDenominator();
      return new Fraction(numerator, denominator);
    }
    return fraction;
  }

  protected Fraction convertSimpleToMixedFraction(long numerator, long denominator) {
    // Use ABS to properly make a division between negative numbers (for subtraction calculation)
    long div = Math.abs(numerator) / Math.abs(denominator);
    if(div >= 2) {
      // Convert back to Mixed Fraction
      long fullNumber = numerator / denominator;
      long newNumerator = Math.abs(numerator - fullNumber * denominator);
      return simplifyFraction(fullNumber, newNumerator, denominator);
    } else {
      return simplifyFraction(1, numerator, denominator);
    }
  }

  /**
   * Search for a Common divide number in order to simplify the fraction
   * Once the divide number is found, start over until no common number is found
   * @return Simplified fraction
   */
  protected Fraction simplifyFraction(long fullNumber, long numerator, long denominator) {
    long max = Math.min(numerator, denominator);

    for(int i=2; i<=max; i++) {
      if(numerator % i == 0 && denominator % i == 0) {
        numerator = numerator / i;
        denominator = denominator / i;
        // Start the search again after any common partition is found
        i = 2;
      }
    }
    return new Fraction(fullNumber, numerator, denominator);
  }
}
