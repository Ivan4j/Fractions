package com.onelogin.fractions;

import com.onelogin.fractions.model.Equation;
import com.onelogin.fractions.model.Fraction;
import com.onelogin.fractions.model.Solution;
import com.onelogin.fractions.solver.SolverManager;
import com.onelogin.fractions.validation.Parser;

public class FractionsMain {
  public static void main(String[] args) {

    // TODO: Steps
    if(args.length <= 2) {
      System.out.println("Invalid Equation");
      return;
    }

    // Validate and Parse
    Equation equation = Parser.parse(args);

    // Execute corresponding Operation In Order (mult & div first, addition and subtraction last)
    SolverManager solverManager = new SolverManager();
    Solution solution = solverManager.solve(equation);

    // Return result
    printSolution(solution);
  }

  private static void printSolution(Solution solution) {

    if(solution.getSolvedEquation() == null) {
      System.out.println("Invalid Fraction");
      return;
    }

    Fraction solvedEquation = solution.getSolvedEquation();

    if(Math.abs(solvedEquation.getFullNumber()) != 1) {
      System.out.print(solvedEquation.getFullNumber() + "_");
    }

    System.out.print(solvedEquation.getNumerator() + "/" + solvedEquation.getDenominator());
  }
}
