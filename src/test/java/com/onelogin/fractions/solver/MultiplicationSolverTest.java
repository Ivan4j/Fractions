package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationSolverTest {

  private MultiplicationSolver multiplicationSolver;

  @BeforeEach
  public void init() {
    multiplicationSolver = new MultiplicationSolver();
  }

  @Test
  public void Should_return_mixed_fraction_when_both_terms_are_mixed() {

    // Input: 5_3/4, 2_9/3
    Fraction firstTerm = new Fraction(5L, 3L, 4L);
    Fraction secondTerm = new Fraction(2L, 9L, 3L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 28);
    assertEquals(fractionResult.getNumerator(), 3);
    assertEquals(fractionResult.getDenominator(), 4);
  }

  @Test
  public void Should_return_mixed_fraction_when_first_term_is_mixed() {

    // Input: 5_3/4, 15
    Fraction firstTerm = new Fraction(5L, 3L, 4L);
    Fraction secondTerm = new Fraction(15L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 86);
    assertEquals(fractionResult.getNumerator(), 1);
    assertEquals(fractionResult.getDenominator(), 4);
  }

  @Test
  public void Should_return_mixed_fraction_when_second_term_is_mixed() {

    // Input: 7, 2_9/3
    Fraction firstTerm = new Fraction(7L);
    Fraction secondTerm = new Fraction(2L, 9L, 3L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 35);
  }

  @Test
  public void Should_return_simple_fraction_when_both_terms_are_simple() {

    // Input: 5/7, 2/3
    Fraction firstTerm = new Fraction(5L, 7L);
    Fraction secondTerm = new Fraction(2L, 3L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 10);
    assertEquals(fractionResult.getDenominator(), 21);
  }

  @Test
  public void Should_return_simple_fraction_when_first_term_is_full_number() {

    // input: 5, 2/3
    Fraction firstTerm = new Fraction(5L);
    Fraction secondTerm = new Fraction(2L, 3L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 10);
    assertEquals(fractionResult.getDenominator(), 3);
  }

  @Test
  public void Should_return_simple_fraction_when_second_term_is_full_number() {

    // input: 5/7, 8
    Fraction firstTerm = new Fraction(5L, 7L);
    Fraction secondTerm = new Fraction(8L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 40);
    assertEquals(fractionResult.getDenominator(), 7);
  }


  @Test
  public void Should_return_simple_number_when_both_terms_are_full() {

    // input: 5, 8
    Fraction firstTerm = new Fraction(5L);
    Fraction secondTerm = new Fraction(8L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getNumerator(), 40);
  }

  @Test
  public void Should_return_proper_fraction_when_first_term_is_negative() {

    // input: -1/3, 3/4
    Fraction firstTerm = new Fraction(-1L, 3L);
    Fraction secondTerm = new Fraction(3L, 4L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), -1);
    assertEquals(fractionResult.getDenominator(), 4);
  }

  @Test
  public void Should_return_proper_fraction_when_second_term_is_negative() {

    // input: 1/3, -3/4
    Fraction firstTerm = new Fraction(1L, 3L);
    Fraction secondTerm = new Fraction(-3L, 4L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), -1L);
    assertEquals(fractionResult.getDenominator(), 4L);
  }

  @Test
  public void Should_return_proper_fraction_when_first_term_with_full_number_is_negative() {

    // input: -3_5/8, 4/7
    Fraction firstTerm = new Fraction(-3L, 5L, 8L);
    Fraction secondTerm = new Fraction(4L, 7L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), -2L);
    assertEquals(fractionResult.getNumerator(), 1L);
    assertEquals(fractionResult.getDenominator(), 14L);
  }

  @Test
  public void Should_return_proper_fraction_when_first_term_with_full_number_is_negative_and_second_is_full() {

    // input: -3_5/8, 7
    Fraction firstTerm = new Fraction(-3L, 5L, 8L);
    Fraction secondTerm = new Fraction(7L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), -25L);
    assertEquals(fractionResult.getNumerator(), 3L);
    assertEquals(fractionResult.getDenominator(), 8L);
  }

  @Test
  public void Should_return_proper_fraction_when_second_term_with_full_number_is_negative() {

    // input: 5/8, -3_4/7
    Fraction firstTerm = new Fraction(5L, 8L);
    Fraction secondTerm = new Fraction(-3L, 4L, 7L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), -2L);
    assertEquals(fractionResult.getNumerator(), 13L);
    assertEquals(fractionResult.getDenominator(), 56L);
  }

  @Test
  public void Should_return_proper_fraction_when_second_term_with_full_number_is_negative_and_first_is_full() {

    // input: 5, -3_4/7
    Fraction firstTerm = new Fraction(5L);
    Fraction secondTerm = new Fraction(-3L, 4L, 7L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), -17L);
    assertEquals(fractionResult.getNumerator(), 6L);
    assertEquals(fractionResult.getDenominator(), 7L);
  }

  @Test
  public void Should_return_proper_result_when_using_fraction_with_same_numbers() {

    // input: 5_5/5, 3_3/3
    Fraction firstTerm = new Fraction(5L, 5L, 5L);
    Fraction secondTerm = new Fraction(3L, 3L, 3L);

    Fraction fractionResult = multiplicationSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 24L);
  }
}