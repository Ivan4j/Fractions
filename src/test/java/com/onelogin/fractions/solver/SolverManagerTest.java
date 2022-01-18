package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Equation;
import com.onelogin.fractions.model.Fraction;
import com.onelogin.fractions.model.Operator;
import com.onelogin.fractions.model.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolverManagerTest {

  private SolverManager solverManager;

  @BeforeEach
  public void init() {
    solverManager = new SolverManager();
  }

  @Test
  public void should_solve_addition_equation_with_two_terms() {

    // Input: 5_2/3 + 8_5/9
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.ADD);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 14);
    assertEquals(solvedEquation.getNumerator(), 2);
    assertEquals(solvedEquation.getDenominator(), 9);
  }

  @Test
  public void should_solve_subtraction_equation_with_two_terms() {

    // Input: 5_2/3 - 8_5/9
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.SUB);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), -2);
    assertEquals(solvedEquation.getNumerator(), 8);
    assertEquals(solvedEquation.getDenominator(), 9);
  }

  @Test
  public void should_solve_multiplication_equation_with_two_terms() {

    // Input: 5_2/3 * 8_5/9
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.MULT);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 48);
    assertEquals(solvedEquation.getNumerator(), 13);
    assertEquals(solvedEquation.getDenominator(), 27);
  }

  @Test
  public void should_solve_division_equation_with_two_terms() {

    // Input: 5_2/3 / 8_5/9
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.DIV);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertNull(solvedEquation.getFullNumber());
    assertEquals(solvedEquation.getNumerator(), 51);
    assertEquals(solvedEquation.getDenominator(), 77);
  }

  @Test
  public void should_solve_addition_and_subtraction_equation_with_three_terms() {

    // Input: 5_2/3 + 8_5/9 - 4/7
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);
    Fraction term3 = new Fraction(4L, 7L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.ADD);
    operators.add(Operator.SUB);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 13);
    assertEquals(solvedEquation.getNumerator(), 41);
    assertEquals(solvedEquation.getDenominator(), 63);
  }

  @Test
  public void should_solve_subtraction_and_addition_equation_with_three_terms() {

    // Input: 5_2/3 - 8_5/9 + 4/7
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);
    Fraction term3 = new Fraction(4L, 7L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.SUB);
    operators.add(Operator.ADD);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), -2);
    assertEquals(solvedEquation.getNumerator(), 20);
    assertEquals(solvedEquation.getDenominator(), 63);
  }

  @Test
  public void should_solve_multiplication_and_division_equation_with_three_terms() {

    // Input: 5_2/3 * 8_5/9 / 4/7
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);
    Fraction term3 = new Fraction(4L, 7L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.MULT);
    operators.add(Operator.DIV);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 84);
    assertEquals(solvedEquation.getNumerator(), 91);
    assertEquals(solvedEquation.getDenominator(), 108);
  }

  @Test
  public void should_solve_division_and_multiplication_equation_with_three_terms() {

    // Input: 5_2/3 / 8_5/9 * 4/7
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);
    Fraction term3 = new Fraction(4L, 7L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.DIV);
    operators.add(Operator.MULT);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertNull(solvedEquation.getFullNumber());
    assertEquals(solvedEquation.getNumerator(), 204);
    assertEquals(solvedEquation.getDenominator(), 539);
  }

  @Test
  public void should_solve_addition_and_multiplication_equation_with_three_terms() {

    // Input: 5_2/3 + 8_5/9 * 4/7
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);
    Fraction term3 = new Fraction(4L, 7L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.ADD);
    operators.add(Operator.MULT);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 10);
    assertEquals(solvedEquation.getNumerator(), 5);
    assertEquals(solvedEquation.getDenominator(), 9);
  }

  @Test
  public void should_solve_multiplication_and_addition_equation_with_three_terms() {

    // Input: 5_2/3 * 8_5/9 + 4/7
    Fraction term1 = new Fraction(5L, 2L, 3L);
    Fraction term2 = new Fraction(8L, 5L, 9L);
    Fraction term3 = new Fraction(4L, 7L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.MULT);
    operators.add(Operator.ADD);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 49);
    assertEquals(solvedEquation.getNumerator(), 10);
    assertEquals(solvedEquation.getDenominator(), 189);
  }

  @Test
  public void should_solve_equation_with_five_terms_and_different_operators() {

    // Input: 3/7 + 9_2/5 / 3_8/13 - 5/3 * 2/9
    Fraction term1 = new Fraction(3L, 7L);
    Fraction term2 = new Fraction(9L, 2L, 5L);
    Fraction term3 = new Fraction(3L, 8L, 13L);
    Fraction term4 = new Fraction(5L, 3L);
    Fraction term5 = new Fraction(2L, 9L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);
    fractions.add(term4);
    fractions.add(term5);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.ADD);
    operators.add(Operator.DIV);
    operators.add(Operator.SUB);
    operators.add(Operator.MULT);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), 2);
    assertEquals(solvedEquation.getNumerator(), 622);
    assertEquals(solvedEquation.getDenominator(), 945);
  }

  @Test
  public void should_solve_equation_with_ten_terms_and_different_operators() {

    // Input: 3/7 + 9_2/5 / 3_8/13 - 5/3 * 2/9 + 5 - 12_1/4 * 33_1/14 / 14 + 77/45
    Fraction term1 = new Fraction(3L, 7L);
    Fraction term2 = new Fraction(9L, 2L, 5L);
    Fraction term3 = new Fraction(3L, 8L, 13L);
    Fraction term4 = new Fraction(5L, 3L);
    Fraction term5 = new Fraction(2L, 9L);
    Fraction term6 = new Fraction(5L);
    Fraction term7 = new Fraction(12L, 1L, 4L);
    Fraction term8 = new Fraction(33L, 1L, 14L);
    Fraction term9 = new Fraction(14L);
    Fraction term10 = new Fraction(77L, 45L);

    List<Fraction> fractions = new ArrayList<>();
    fractions.add(term1);
    fractions.add(term2);
    fractions.add(term3);
    fractions.add(term4);
    fractions.add(term5);
    fractions.add(term6);
    fractions.add(term7);
    fractions.add(term8);
    fractions.add(term9);
    fractions.add(term10);

    List<Operator> operators = new ArrayList<>();
    operators.add(Operator.ADD);
    operators.add(Operator.DIV);
    operators.add(Operator.SUB);
    operators.add(Operator.MULT);
    operators.add(Operator.ADD);
    operators.add(Operator.SUB);
    operators.add(Operator.MULT);
    operators.add(Operator.DIV);
    operators.add(Operator.ADD);

    Equation eq = new Equation(fractions, operators);

    Solution solution = solverManager.solve(eq);

    assertNotNull(solution);

    Fraction solvedEquation = solution.getSolvedEquation();
    assertNotNull(solvedEquation);
    assertEquals(solvedEquation.getFullNumber(), -19);
    assertEquals(solvedEquation.getNumerator(), 8591);
    assertEquals(solvedEquation.getDenominator(), 15120);
  }
}