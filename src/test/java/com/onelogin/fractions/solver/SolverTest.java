package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolverTest {

  private Solver solver;

  @BeforeEach
  public void init() {
    solver = new AdditionSolver();
  }

  @Test
  public void should_convert_mixed_fraction_to_simple() {

    Fraction fraction = new Fraction(5L, 2L, 3L);

    Fraction simpleFraction = solver.convertMixedToSimpleFraction(fraction);

    assertNotNull(simpleFraction);
    assertNull(simpleFraction.getFullNumber());
    assertEquals(simpleFraction.getNumerator(), 17);
    assertEquals(simpleFraction.getDenominator(), 3);
  }

  @Test
  public void should_convert_simple_fraction_to_mixed() {

    Fraction simpleFraction = solver.convertSimpleToMixedFraction(17L, 3L);

    assertNotNull(simpleFraction);
    assertEquals(simpleFraction.getFullNumber(), 5L);
    assertEquals(simpleFraction.getNumerator(), 2);
    assertEquals(simpleFraction.getDenominator(), 3);
  }

  @Test
  public void should_return_a_simplified_simple_fraction_with_full_number() {

    Fraction simpleFraction = solver.simplifyFraction(5L, 250L, 500L);

    assertNotNull(simpleFraction);
    assertEquals(simpleFraction.getFullNumber(), 5);
    assertEquals(simpleFraction.getNumerator(), 1);
    assertEquals(simpleFraction.getDenominator(), 2);
  }

  @Test
  public void should_return_a_simplified_simple_fraction_with_no_full_number() {

    Fraction simpleFraction = solver.simplifyFraction(null, 250L, 500L);

    assertNotNull(simpleFraction);
    assertNull(simpleFraction.getFullNumber());
    assertEquals(simpleFraction.getNumerator(), 1);
    assertEquals(simpleFraction.getDenominator(), 2);
  }

  @Test
  public void should_return_a_crossed_addition_between_two_simple_fractions() {

    Fraction fraction1 = new Fraction(2L, 3L);
    Fraction fraction2 = new Fraction(11L, 13L);

    // (2 * 13) + (11 * 3) = 50
    Long crossedAddition = solver.getCrossAddition(fraction1, fraction2, false);

    assertNotNull(crossedAddition);
    assertEquals(crossedAddition, 59);
  }

  @Test
  public void should_return_a_crossed_negative_addition_between_two_simple_fractions() {

    Fraction fraction1 = new Fraction(2L, 3L);
    Fraction fraction2 = new Fraction(11L, 13L);

    // (2 * 13) - (11 * 3) = -7
    Long crossedAddition = solver.getCrossAddition(fraction1, fraction2, true);

    assertNotNull(crossedAddition);
    assertEquals(crossedAddition, -7);
  }

  @Test
  public void should_return_true_if_fraction_is_mixed() {

    Fraction fraction = new Fraction(5L, 2L, 3L);

    boolean isMixedFraction = solver.isMixedFraction(fraction);

    assertTrue(isMixedFraction);
  }

  @Test
  public void should_return_false_if_fraction_is_simple() {

    Fraction fraction = new Fraction(2L, 3L);

    boolean isMixedFraction = solver.isMixedFraction(fraction);

    assertFalse(isMixedFraction);
  }
}