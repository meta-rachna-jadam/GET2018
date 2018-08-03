/**
 * This class is use by the ConvertInfixToPostfix and PostfixEvaluator class
 * @author Rachna
 *
 */
public class EvaluatorUtility {
	/**
	 * check whether string contains only digits or not
	 * @param value
	 * @return true if string contains only digits, otherwise false
	 */
	public static boolean isDigit(String value) {
		for (int index = 0; index < value.length(); index++) {
			if (!((value.charAt(index) >= '0') && (value.charAt(index) <= '9'))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * check whether string is ArithmeticOperator or not
	 * @param value
	 * @return true if string is ArithmeticOperator or not, otherwise false
	 */
	public static boolean isArithmeticOperator(String value) {
		if (value.length() == 1) {
			char operator = value.charAt(0);
			return (operator == '+' || operator == '-' || operator == '*'
					|| operator == '/' || operator == '^' || operator == '%');
		}
		return false;
	}

	/**
	 * check whether string contains only alphanumarics or not
	 * @param value
	 * @return true if string contains only alphanumarics, otherwise false
	 */
	public static boolean isDigitOrAlphabet(String value) {
		String valueInUpperCase = value;
		for (int index = 0; index < valueInUpperCase.length(); index++) {
			if (!(isDigit(""+value.charAt(index)) || Character.isAlphabetic(value.charAt(index)))){
			    return false;
			}
		}
		return true;
	}

	/**
	 * return int according to Precedence 
	 * @param operator
	 * @return
	 */
	public static int getPrecedence(String operator) {
		if ("||".equals(operator)) {
			return 1;
		} else if ("&&".equals(operator)) {
			return 2;
		} else if ("!=".equals(operator) || "==".equals(operator)) {
			return 3;
		} else if (">=".equals(operator) || "<=".equals(operator)
				|| "<".equals(operator) || ">".equals(operator)) {
			return 4;
		} else if ("+".equals(operator) || "-".equals(operator)) {
			return 5;
		} else if ("*".equals(operator) || "%".equals(operator)
				|| "/".equals(operator)) {
			return 6;
		} else {
			return -1;
		}
	}
}
