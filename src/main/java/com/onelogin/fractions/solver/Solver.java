package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;

public abstract class Solver {

  public abstract Fraction solve(Fraction firstTerm, Fraction secondTerm);

  /**
   * Transforms a Mixed fraction into a Simple one:
   * Multiply the full number by the denominator and add it to the numerator.
   * This will becomes the new numerator of the simple fraction.
   * The denominator will be the same from the original denominator.
   * @param fraction Mixed fraction
   * @return Simple fraction with Numerator and Denominator only.
   */
  protected Fraction convertMixedToSimpleFraction(Fraction fraction) {
    if(fraction.getFullNumber() != null && fraction.getNumerator() != null && fraction.getDenominator() != null) {
      long multiplication = fraction.getDenominator() * fraction.getFullNumber();
      long numerator = 0;
      if(multiplication > 0) {
        numerator = fraction.getDenominator() * fraction.getFullNumber() + fraction.getNumerator();
      } else {
        numerator = fraction.getDenominator() * fraction.getFullNumber() - fraction.getNumerator();
      }
      long denominator = fraction.getDenominator();
      return new Fraction(numerator, denominator);
    } else if(fraction.getFullNumber() != null && fraction.getNumerator() == null && fraction.getDenominator() == null) {
      return new Fraction(null, fraction.getFullNumber(), 1L);
    }
    return fraction;
  }

  /**
   * Transform a simple fraction into a Mixed fraction:
   * Divide the numerator by the denominator.
   * The resultant becomes the full number.
   * The remainder becomes the numerator of the new fraction.
   * The denominator will be the same from the original fraction.
   * @param numerator Numerator from the simple fraction
   * @param denominator Denominator from the Simple fraction
   * @return Mixed fraction
   */
  protected Fraction convertSimpleToMixedFraction(Long numerator, Long denominator) {
    // Use Math.abs() to properly make a division between negative numbers (for subtraction calculation)
    long div = Math.abs(numerator) / Math.abs(denominator);
    if(div >= 1) {
      // Convert back to Mixed Fraction
      long fullNumber = numerator / denominator;
      long newNumerator = Math.abs(numerator - fullNumber * denominator);
      return simplifyFraction(fullNumber, newNumerator, denominator);
    } else {
      return simplifyFraction(null, numerator, denominator);
    }
  }

  /**
   * Search for a Common divide number in order to simplify the fraction
   * Once the divide number is found, start over until no common number is found
   * @return Simplified fraction
   */
  protected Fraction simplifyFraction(Long fullNumber, Long numerator, Long denominator) {
    long max = Math.min(Math.abs(numerator), Math.abs(denominator));

    for(int i=2; i<=max;) {
      if(numerator % i == 0 && denominator % i == 0) {
        numerator = numerator / i;
        denominator = denominator / i;
        // Start the search again after any common partition is found
        i = 2;
        continue;
      }
      i++;
    }
    return new Fraction(fullNumber, numerator, denominator);
  }

  protected Long getCrossAddition(Fraction firstTerm, Fraction secondTerm, boolean isNegativeAddition) {
    long firstMult = firstTerm.getNumerator() * secondTerm.getDenominator();
    long secondMult = firstTerm.getDenominator() * secondTerm.getNumerator();
    return isNegativeAddition ? firstMult - secondMult : firstMult + secondMult;
  }

  protected boolean isMixedFraction(Fraction fraction) {
    return fraction.getFullNumber() != null && fraction.getNumerator() != null;
  }
}
