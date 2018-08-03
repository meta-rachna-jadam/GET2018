import java.util.Stack;

public class ConvertInfixToPostfix {
    public final String[] expressionArray;
    Stack<String> expressionStack;

    public ConvertInfixToPostfix(String infixExpression) throws AssertionError {
        if (infixExpression == null) {
            throw new AssertionError("Expression is null");
        }
        this.expressionArray = infixExpression.split(" ");
        this.expressionStack = new Stack<String>();
        if(!EvaluatorUtility.isDigitOrAlphabet(expressionArray[expressionArray.length - 1])){
			throw new AssertionError("Invalid expression");
		}
	}

    /**
     * Convert infix to postfix 
     * @return postfix expression
     * @throws AssertionError if wrong infix expression is given
     */
	public String convertInfixToPostfix() throws AssertionError {
		if (expressionArray.length < 2) {
			throw new AssertionError("Invalid expression");
		}
		boolean isDigitOrAlphabetAppearFirstTime = true;
		StringBuilder posfixExpression = new StringBuilder();
		for (int index = 0; index < expressionArray.length; index++) {
			if (EvaluatorUtility.isDigitOrAlphabet(expressionArray[index])) {
				if(!isDigitOrAlphabetAppearFirstTime){
					throw new AssertionError("Invalid expression");
				}
				posfixExpression.append(expressionArray[index]);
				isDigitOrAlphabetAppearFirstTime = false;
			} else if ("(".equals(expressionArray[index])) {
				expressionStack.push(expressionArray[index]);
				isDigitOrAlphabetAppearFirstTime = true;
			} else if (")".equals(expressionArray[index])) {
				isDigitOrAlphabetAppearFirstTime = true;
				while (!expressionStack.isEmpty()
						&& !("(".equals(expressionStack.peek()))) {
					posfixExpression.append(expressionStack.pop());
				}
				if (!expressionStack.isEmpty() && ( "(".equals(expressionStack.peek()))){
					expressionStack.pop();
				}// invalid expression                
                else
                	throw new AssertionError("Invalid expression");
			} else {
				isDigitOrAlphabetAppearFirstTime = true;
				while ((!expressionStack.isEmpty())
						&& ((EvaluatorUtility
								.getPrecedence(expressionArray[index])) <= (EvaluatorUtility
								.getPrecedence(expressionStack.peek())))) {
					posfixExpression.append(expressionStack.pop());
				}
				expressionStack.push(expressionArray[index]);
			}
		}
		while (!expressionStack.isEmpty()) {
			if("(".equals(expressionStack.peek()))
			{
				throw new AssertionError("Invalid expression");
			}
			posfixExpression.append(expressionStack.pop());
		}
		
		return posfixExpression.toString();
	}
}