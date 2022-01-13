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
  private Long fullNumber;
  private Long numerator;
  private Long denominator;

  public Fraction(Long fullNumber) {
    this.fullNumber = fullNumber;
    this.numerator = null;
    this.denominator = null;
  }

  public Fraction(Long numerator, Long denominator) {
    this.fullNumber = null;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(Long fullNumber, Long numerator, Long denominator) {
    this.fullNumber = fullNumber;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Long getFullNumber() {
    return fullNumber;
  }

  public void setFullNumber(Long fullNumber) {
    this.fullNumber = fullNumber;
  }

  public Long getNumerator() {
    return numerator;
  }

  public void setNumerator(Long numerator) {
    this.numerator = numerator;
  }

  public Long getDenominator() {
    return denominator;
  }

  public void setDenominator(Long denominator) {
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
