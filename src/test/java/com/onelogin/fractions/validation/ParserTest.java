package com.onelogin.fractions.validation;

import com.onelogin.fractions.model.Equation;
import com.onelogin.fractions.model.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

  @Test
  public void should_return_equation_instance_when_input_has_many_white_spaces() {

    // Input: 5_2/3 + 7/9
    // Using several white spaces
    String[] input = {"  ?    ", "    5_2/3 ",  " +    ", "   7/9 "};

    Equation parsedEquation = Parser.parse(input);

    assertNotNull(parsedEquation);
    assertNotNull(parsedEquation.getOperators());
    assertNotNull(parsedEquation.getFractions());

    assertEquals(parsedEquation.getOperators().size(), 1);
    assertEquals(parsedEquation.getFractions().size(), 2);
  }

  @Test
  public void should_return_equation_instance_when_no_extra_white_spaces() {

    // Input: 5_2/3 + 7/9
    // Using no extra white spaces
    String[] input = {"?", "5_2/3",  "+", "7/9"};

    Equation parsedEquation = Parser.parse(input);

    assertNotNull(parsedEquation);
    assertNotNull(parsedEquation.getOperators());
    assertNotNull(parsedEquation.getFractions());

    assertEquals(parsedEquation.getOperators().size(), 1);
    assertEquals(parsedEquation.getFractions().size(), 2);
  }


  @Test
  public void should_return_equation_instance_when_question_mark_is_missing() {

    // Input: 5_2/3 + 7/9
    // Using no extra white spaces
    String[] input = {"5_2/3",  "+", "7/9"};

    Equation parsedEquation = Parser.parse(input);

    assertNotNull(parsedEquation);
    assertNotNull(parsedEquation.getOperators());
    assertNotNull(parsedEquation.getFractions());

    assertEquals(parsedEquation.getOperators().size(), 1);
    assertEquals(parsedEquation.getFractions().size(), 2);
  }

  @Test
  public void should_return_one_fraction_when_only_one_term_found() {

    // Input: 5_2/3
    // One Fraction is valid
    String[] input = {"?", "5_2/3"};

    Equation parsedEquation = Parser.parse(input);

    assertNotNull(parsedEquation);

    assertEquals(parsedEquation.getFractions().size(), 1);
    assertEquals(parsedEquation.getOperators().size(), 0);

    Fraction solvedEquation = parsedEquation.getFractions().get(0);
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 5);
    assertEquals(solvedEquation.getNumerator(), 2);
    assertEquals(solvedEquation.getDenominator(), 3);
  }

  @Test
  public void should_return_null_when_only_one_term_found_and_one_operator() {

    // Input: 5_2/3 +
    // Incomplete Equation
    String[] input = {"  ? ", "5_2/3",  "+"};

    Equation parsedEquation = Parser.parse(input);

    assertNull(parsedEquation);
  }

  @Test
  public void should_return_null_when_not_valid_operator_found() {

    // Input: 5_2/3 , 7/9
    // Using colon/comma instead of valid operator
    String[] input1 = {"  ? ", "5_2/3",  ",", "7/9"};

    // Using white space of valid operator
    String[] input2 = {"  ? ", "5_2/3",  " ", "7/9"};

    // Using 'x' instead of valid operator
    String[] input3 = {"  ? ", "5_2/3",  "x", "7/9"};

    // Using ? instead of valid operator
    String[] input4 = {"  ? ", "5_2/3",  "?", "7/9"};

    // Using & instead of valid operator
    String[] input5 = {"  ? ", "5_2/3",  "&", "7/9"};

    // Using ^ instead of valid operator
    String[] input6 = {"  ? ", "5_2/3",  "^", "7/9"};

    // Using % instead of valid operator
    String[] input7 = {"  ? ", "5_2/3",  "%s", "7/9"};

    Equation parsedEquation1 = Parser.parse(input1);
    Equation parsedEquation2 = Parser.parse(input2);
    Equation parsedEquation3 = Parser.parse(input3);
    Equation parsedEquation4 = Parser.parse(input4);
    Equation parsedEquation5 = Parser.parse(input5);
    Equation parsedEquation6 = Parser.parse(input6);
    Equation parsedEquation7 = Parser.parse(input7);

    assertNull(parsedEquation1);
    assertNull(parsedEquation2);
    assertNull(parsedEquation3);
    assertNull(parsedEquation4);
    assertNull(parsedEquation5);
    assertNull(parsedEquation6);
    assertNull(parsedEquation7);
  }

  @Test
  public void should_return_null_when_invalid_fraction_found() {

    // Input: 5_2_3
    // Invalid Fraction
    String[] input = {"  ? ", "5_2_3"};

    Equation parsedEquation = Parser.parse(input);

    assertNull(parsedEquation);
  }

  @Test
  public void should_return_null_when_invalid_fraction_found_in_equation() {

    // Input: 2/5 + 5_4
    // Second term is an Invalid Fraction
    String[] input = {"  ? ", "2/5", "+", "5_4"};

    Equation parsedEquation = Parser.parse(input);

    assertNull(parsedEquation);
  }

  @Test
  public void should_return_null_when_more_operators_than_terms_found() {

    // Input: / + 5_4/3
    // Invalid Equation
    String[] input1 = {"  ? ", "/", "+", "5_4/3"};

    // Input: / 5_4/3 *
    // Invalid Equation
    String[] input2 = {"  ? ", "/", "5_4/3", "*"};

    // Input: 5_4/3 *
    // Invalid Equation
    String[] input3 = {"  ? ", "5_4/3", "*"};

    Equation parsedEquation1 = Parser.parse(input1);
    Equation parsedEquation2 = Parser.parse(input2);
    Equation parsedEquation3 = Parser.parse(input3);

    assertNull(parsedEquation1);
    assertNull(parsedEquation2);
    assertNull(parsedEquation3);
  }
}