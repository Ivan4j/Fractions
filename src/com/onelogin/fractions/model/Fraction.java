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
  private int fullNumber;
  private int numerator;
  private int denominator;

  public Fraction(int numerator, int denominator) {
    this.fullNumber = 1;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(int fullNumber, int numerator, int denominator) {
    this.fullNumber = fullNumber;
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getFullNumber() {
    return fullNumber;
  }

  public void setFullNumber(int fullNumber) {
    this.fullNumber = fullNumber;
  }

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
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
