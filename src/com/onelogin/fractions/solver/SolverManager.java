package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Equation;
import com.onelogin.fractions.model.Fraction;
import com.onelogin.fractions.model.Operator;
import com.onelogin.fractions.model.Solution;

/**
 * Responsible of executing the solvers in the expected order
 */
public class SolverManager {

  public Solution solve(Equation equation) {

    getNextOperation(equation);

    return null;
  }

  private Equation getNextOperation(Equation equation) {

    for(int i=0; i<equation.getOperators().size(); i++) {

      Fraction leftFraction = equation.getFractions().get(i);
      Fraction rightFraction = equation.getFractions().get(i + 1); // TODO ArrayIndexOutOfBoundEx
      Fraction solvedFraction = null;
      if(equation.getOperators().get(i) == Operator.MULT) {
        solvedFraction = new MultiplicationSolver().solve(leftFraction, rightFraction);
      } else if(equation.getOperators().get(i) == Operator.DIV) {
        solvedFraction = new DivisionSolver().solve(leftFraction, rightFraction);
      } else if(equation.getOperators().get(i) == Operator.ADD) {
        solvedFraction = new AdditionSolver().solve(leftFraction, rightFraction);
      } else if(equation.getOperators().get(i) == Operator.SUB) {
        solvedFraction = new SubtractionSolver().solve(leftFraction, rightFraction);
      }

      System.out.println(solvedFraction);

      equation.getOperators().remove(i);
      equation.getFractions().remove(i);
      equation.getFractions().remove(i);
      equation.getFractions().add(i, solvedFraction);
    }

    return equation;
  }
}
