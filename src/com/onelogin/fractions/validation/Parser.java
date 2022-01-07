package com.onelogin.fractions.validation;

import com.onelogin.fractions.model.Fraction;
import com.onelogin.fractions.model.Equation;
import com.onelogin.fractions.model.Operator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

  public static Equation parse(String[] args) {
    List<Fraction> fractions = new ArrayList<>();
    List<Operator> operators = new ArrayList<>();

    for(String param : args) {
      // Skip white spaces
      if(param != null && !param.isEmpty() && !param.equals(" ")) {
        // Find any term with digits
        if(param.matches(".*\\d.*")) {
          fractions.add(parseTerm(param));
        } else if(param.equals("+")) {
          operators.add(Operator.ADD);
        } else if(param.equals("+")) {
          operators.add(Operator.ADD);
        } else if(param.equals("-")) {
          operators.add(Operator.SUB);
        } else if(param.equals("*")) {
          operators.add(Operator.MULT);
        } else if(param.equals("/")) {
          operators.add(Operator.DIV);
        }
      }
    }

    if(operators.isEmpty() || fractions.isEmpty()) {
      return null;
    }

    return new Equation(fractions, operators);
  }

  private static Fraction parseTerm(String param) throws ArrayIndexOutOfBoundsException {

    int fullNumber = 1;
    int numerator = 1;
    int denominator = 1;

    String fraction = "";

    // Verify if this term is a Mixed Fraction
    if(param.indexOf("_") > 0) {
      String[] fractionTerms = param.split("_");
      fullNumber = Integer.valueOf(fractionTerms[0]);
      fraction = fractionTerms[1];
    }

    int fractionSymbolIndex = fraction.indexOf("/");
    if(fractionSymbolIndex > 0) {
      numerator = Integer.valueOf(fraction.substring(0, fractionSymbolIndex));
      denominator = Integer.valueOf(fraction.substring(fractionSymbolIndex + 1, fraction.length()));
    } else {
      fullNumber = Integer.valueOf(param);
    }

    System.out.println(param);
    System.out.println("-----");

    System.out.println(fullNumber);
    //System.out.println(fraction);
    System.out.println(numerator);
    System.out.println(denominator);
    System.out.println("******");

    return new Fraction(fullNumber, numerator, denominator);
  }
}
