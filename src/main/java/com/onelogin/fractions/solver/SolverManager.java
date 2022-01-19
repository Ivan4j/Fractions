package com.onelogin.fractions.solver;

import com.onelogin.fractions.model.Equation;
import com.onelogin.fractions.model.Fraction;
import com.onelogin.fractions.model.Operator;
import com.onelogin.fractions.model.Solution;

/**
 * Responsible for executing each operation in order of precedence:
 * First: Multiplication or Division
 * Last: Addition or Subtraction
 */
public class SolverManager {

  public Solution solve(Equation equation) {
    return new Solution(manageCalculationOrder(equation));
  }

  private Fraction manageCalculationOrder(Equation equation) {

    if(equation == null) {
      return null;
    }

    while (equation.getOperators().size() > 0) {
      Fraction solvedFraction = null;
      Operator type = Operator.ADD;
      int index = -1;

      // Find the order to execute the operations
      // Same level operators should be executed from Left to Right as found in the Equation
      if (equation.getOperators().contains(Operator.MULT) || equation.getOperators().contains(Operator.DIV)) {
        int multIndex = equation.getOperators().indexOf(Operator.MULT);
        int divIndex = equation.getOperators().indexOf(Operator.DIV);
        if((multIndex != -1 && multIndex < divIndex) || (divIndex == -1  && multIndex != -1)) {
          index = multIndex;
          type = Operator.MULT;
        } else if((divIndex != -1 && divIndex < multIndex) || (multIndex ==  -1 && divIndex != -1)) {
          index = divIndex;
          type = Operator.DIV;
        }
      } else if (equation.getOperators().contains(Operator.ADD) || equation.getOperators().contains(Operator.SUB)) {

        int addIndex = equation.getOperators().indexOf(Operator.ADD);;
        int subIndex = equation.getOperators().indexOf(Operator.SUB);;
        if((addIndex != -1 && addIndex < subIndex) || (subIndex == -1 && addIndex != -1)) {
          index = addIndex;
          type = Operator.ADD;
        } else if((subIndex != -1 && subIndex < addIndex) || (addIndex == -1 && subIndex != -1)) {
          index = subIndex;
          type = Operator.SUB;
        }
      }

      // Solve the current Operation
      solvedFraction = executeOperation(equation, type, index);

      // Updated the Equation by removing two fractions that were already solved in the previous step
      // Add the new solved fraction to the equation
      equation.getOperators().remove(index);
      equation.getFractions().remove(index);
      equation.getFractions().remove(index);
      equation.getFractions().add(index, solvedFraction);
    }

    // Something wrong, there should be 1 item left
    if(equation.getFractions().size() == 0 || equation.getFractions().size() > 1) {
      return null;
    }

    // Return the last fraction, it represents the final calculation
    return equation.getFractions().get(0);
  }

  /**
   * Responsible for executing the corresponding operation logic
   * @param equation represents the full equation cocntaining all the fraction terms and operators
   * @param operator represents the type of operation to execute (Addition, Subtraction, Multiplication or Division)
   * @param operatorIndex represents the index of the operator
   * @return a `solved fraction` after executing the calculation logic
   */
  private Fraction executeOperation(Equation equation, Operator operator, int operatorIndex) {

    Fraction leftFraction = equation.getFractions().get(operatorIndex);
    Fraction rightFraction = equation.getFractions().get(operatorIndex + 1);

    Fraction solvedFraction = null;

    switch (operator) {
      case MULT:
        solvedFraction = new MultiplicationSolver().solve(leftFraction, rightFraction);
        break;
      case DIV:
        solvedFraction = new DivisionSolver().solve(leftFraction, rightFraction);
        break;
      case ADD:
        solvedFraction = new AdditionSolver().solve(leftFraction, rightFraction);
        break;
      case SUB:
        solvedFraction = new SubtractionSolver().solve(leftFraction, rightFraction);
        break;
    }
    return solvedFraction;
  }
}
