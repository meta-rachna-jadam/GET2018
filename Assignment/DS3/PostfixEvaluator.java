import java.util.Stack;

public class PostfixEvaluator {
	private final String[] arrayOfOperandsAndOperators;
	private Stack<String> stackInstance;

	public PostfixEvaluator(String expression) {
		arrayOfOperandsAndOperators = expression.split(" ");
		stackInstance = new Stack<String>();
	}

	/**
	 * evaluate post fix expression
	 * 
	 * @return result of expression
	 * @throws AssertionError
	 *             if expression is wrong
	 */
	public int postfixEvaluation() throws AssertionError {
		if (arrayOfOperandsAndOperators.length < 3) {
			throw new AssertionError("Wrong expression");
		}
		int resultOfExpression = 0;
		int operantOne;
		int operantTwo;
		for (int index = 0; index < arrayOfOperandsAndOperators.length; index++) {
			if (EvaluatorUtility.isDigit(arrayOfOperandsAndOperators[index])) {
				stackInstance.push(arrayOfOperandsAndOperators[index]);
			} else if (EvaluatorUtility
					.isArithmeticOperator(arrayOfOperandsAndOperators[index])) {
				operantTwo = Integer.parseInt(stackInstance.pop());
				operantOne = Integer.parseInt(stackInstance.pop());
				stackInstance.push(""
						+ evaluateExpression(operantOne, operantTwo,
								arrayOfOperandsAndOperators[index]));
			} else {
				throw new AssertionError("Wrong expression");
			}
		}
		resultOfExpression = Integer.parseInt(stackInstance.pop());
		if (stackInstance.isEmpty()) {
			return resultOfExpression;
		}
		throw new AssertionError("Wrong expression");
	}

	/**
	 * this method perform airthmetic operations on the two topmost element of
	 * stack
	 * 
	 * @param operantOne
	 * @param operantTwo
	 * @param operator
	 * @return result of airthmetic operation
	 * @throws AssertionError
	 *             other then airthmetic operators are given
	 */
	private int evaluateExpression(int operantOne, int operantTwo,
			String operator) throws AssertionError {
		if ("+".equals(operator)) {
			return operantOne + operantTwo;
		} else if ("-".equals(operator)) {
			return operantOne - operantTwo;
		} else if ("*".equals(operator)) {
			return operantOne * operantTwo;
		} else if ("/".equals(operator)) {
			return operantOne / operantTwo;
		} else if ("%".equals(operator)) {
			return operantOne % operantTwo;
		} else if ("^".equals(operator)) {
			return (int) Math.pow(operantOne, operantTwo);
		} else {
			throw new AssertionError("Wrong expression");
		}
	}
}
