package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionSolverTest {

  private AdditionSolver additionSolver;

  @BeforeEach
  public void init() {
    additionSolver = new AdditionSolver();
  }

  @Test
  public void Should_return_mixed_fraction_when_both_terms_are_mixed() {

    // Input: 5_3/4, 2_9/3
    Fraction firstTerm = new Fraction(5L, 3L, 4L);
    Fraction secondTerm = new Fraction(2L, 9L, 3L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 10);
    assertEquals(fractionResult.getNumerator(), 3);
    assertEquals(fractionResult.getDenominator(), 4);
  }

  @Test
  public void Should_return_mixed_fraction_when_first_term_is_mixed() {

    // Input: 5_3/4, 15
    Fraction firstTerm = new Fraction(5L, 3L, 4L);
    Fraction secondTerm = new Fraction(15L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 20);
    assertEquals(fractionResult.getNumerator(), 3);
    assertEquals(fractionResult.getDenominator(), 4);
  }

  @Test
  public void Should_return_mixed_fraction_when_second_term_is_mixed() {

    // Input: 7, 2_9/3
    Fraction firstTerm = new Fraction(7L);
    Fraction secondTerm = new Fraction(2L, 9L, 3L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 12L);
  }

  @Test
  public void Should_return_simple_fraction_when_both_terms_are_simple() {

    // Input: 5/7, 2/3
    Fraction firstTerm = new Fraction(5L, 7L);
    Fraction secondTerm = new Fraction(2L, 3L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 29);
    assertEquals(fractionResult.getDenominator(), 21);
  }

  @Test
  public void Should_return_simple_fraction_when_first_term_is_full_number() {

    // input: 5, 2/3
    Fraction firstTerm = new Fraction(5L);
    Fraction secondTerm = new Fraction(2L, 3L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 17);
    assertEquals(fractionResult.getDenominator(), 3);
  }

  @Test
  public void Should_return_simple_fraction_when_second_term_is_full_number() {

    // input: 5/7, 8
    Fraction firstTerm = new Fraction(5L, 7L);
    Fraction secondTerm = new Fraction(8L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 61);
    assertEquals(fractionResult.getDenominator(), 7);
  }


  @Test
  public void Should_return_simple_number_when_both_terms_are_full() {

    // input: 5, 8
    Fraction firstTerm = new Fraction(5L);
    Fraction secondTerm = new Fraction(8L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getNumerator(), 13L);
  }

  @Test
  public void Should_return_proper_fraction_when_first_term_is_negative() {

    // input: -1/3, 3/4
    Fraction firstTerm = new Fraction(-1L, 3L);
    Fraction secondTerm = new Fraction(3L, 4L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), 5L);
    assertEquals(fractionResult.getDenominator(), 12L);
  }

  @Test
  public void Should_return_proper_fraction_when_second_term_is_negative() {

    // input: 1/3, -3/4
    Fraction firstTerm = new Fraction(1L, 3L);
    Fraction secondTerm = new Fraction(-3L, 4L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertNull(fractionResult.getFullNumber());
    assertEquals(fractionResult.getNumerator(), -5L);
    assertEquals(fractionResult.getDenominator(), 12L);
  }

  @Test
  public void Should_return_proper_fraction_when_first_term_with_full_number_is_negative() {

    // input: -3_5/8, 4/7
    Fraction firstTerm = new Fraction(-3L, 5L, 8L);
    Fraction secondTerm = new Fraction(4L, 7L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), -3L);
    assertEquals(fractionResult.getNumerator(), 3L);
    assertEquals(fractionResult.getDenominator(), 56L);
  }

  @Test
  public void Should_return_proper_fraction_when_first_term_with_full_number_is_negative_and_second_is_full() {

    // input: -3_5/8, 7
    Fraction firstTerm = new Fraction(-3L, 5L, 8L);
    Fraction secondTerm = new Fraction(7L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 3L);
    assertEquals(fractionResult.getNumerator(), 3L);
    assertEquals(fractionResult.getDenominator(), 8L);
  }

  @Test
  public void Should_return_proper_fraction_when_second_term_with_full_number_is_negative() {

    // input: 5/8, -3_4/7
    Fraction firstTerm = new Fraction(5L, 8L);
    Fraction secondTerm = new Fraction(-3L, 4L, 7L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), -2L);
    assertEquals(fractionResult.getNumerator(), 53L);
    assertEquals(fractionResult.getDenominator(), 56L);
  }

  @Test
  public void Should_return_proper_fraction_when_second_term_with_full_number_is_negative_and_first_is_full() {

    // input: 5, -3_4/7
    Fraction firstTerm = new Fraction(5L);
    Fraction secondTerm = new Fraction(-3L, 4L, 7L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 1L);
    assertEquals(fractionResult.getNumerator(), 3L);
    assertEquals(fractionResult.getDenominator(), 7L);
  }

  @Test
  public void Should_return_proper_result_when_using_fraction_with_same_numbers() {

    // input: 5_5/5, 3_3/3
    Fraction firstTerm = new Fraction(5L, 5L, 5L);
    Fraction secondTerm = new Fraction(3L, 3L, 3L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 10L);
  }

  @Test
  public void Should_return_proper_result_when_using_fraction_with_same_numbers_inverted() {

    // input: 3_3/3, 5_5/5
    Fraction firstTerm = new Fraction(3L, 3L, 3L);
    Fraction secondTerm = new Fraction(5L, 5L, 5L);

    Fraction fractionResult = additionSolver.solve(firstTerm, secondTerm);

    assertNotNull(fractionResult);
    assertEquals(fractionResult.getFullNumber(), 10L);
  }
}