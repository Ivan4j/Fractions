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
    Fraction solvedEquation = solution.getSolvedEquation();

    if(solvedEquation == null) {
      System.out.println("Invalid Fraction");
      return;
    }

    Long fullNumber = solvedEquation.getFullNumber();
    Long numerator = solvedEquation.getNumerator();
    Long denominator = solvedEquation.getDenominator();

    if(fullNumber != null) {
      System.out.print(fullNumber);
    }
    if(numerator != null && denominator != null) {
      if(denominator != 1 && numerator != 0) {
        if(fullNumber != null) {
          System.out.print("_");
        }
        System.out.print(numerator);
        System.out.print("/");
        System.out.print(denominator);
      } else {
        System.out.print("Invalid Result");
      }
    }
  }
}
