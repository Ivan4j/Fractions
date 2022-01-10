package com.onelogin.fractions.model;

/**
 * Fraction representation
 * E.g.: 3_1/2
 *
 * 3 - fullNumber
 * 1 - numerator
 * 2 - denominator
 */
public class Fraction {
  private long fullNumber;
  private long numerator;
  private long denominator;

  public Fraction(long numerator, long denominator) {
    this.fullNumber = 1;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(long fullNumber, long numerator, long denominator) {
    this.fullNumber = fullNumber;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public long getFullNumber() {
    return fullNumber;
  }

  public void setFullNumber(long fullNumber) {
    this.fullNumber = fullNumber;
  }

  public long getNumerator() {
    return numerator;
  }

  public void setNumerator(long numerator) {
    this.numerator = numerator;
  }

  public long getDenominator() {
    return denominator;
  }

  public void setDenominator(long denominator) {
    this.denominator = denominator;
  }

  @Override
  public String toString() {
    return "Fraction{" + fullNumber +
        " " + numerator +
        " / " + denominator +
        '}';
  }
}
