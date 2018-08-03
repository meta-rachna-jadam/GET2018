import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTestCase {

	@Test
	public void testPostfixEvaluationReturnValueOfExpression() {
		PostfixEvaluator postfixEvaluatorInstanceOne = new PostfixEvaluator(
				"3 2 * 2 ^ 5 3 - 8 4 / * -");
		assertEquals(32, postfixEvaluatorInstanceOne.postfixEvaluation());
		PostfixEvaluator postfixEvaluatorInstanceTwo = new PostfixEvaluator(
				"9 3 / 5 + 7 2 - *");
		PostfixEvaluator postfixEvaluatorInstanceThree = new PostfixEvaluator(
				"5 2 1 - - 3 1 4 + + *");
		assertEquals(40, postfixEvaluatorInstanceTwo.postfixEvaluation());
		assertEquals(32, postfixEvaluatorInstanceThree.postfixEvaluation());
	}

	@Test(expected = AssertionError.class)
	public void testPostfixEvaluationAssertionErrorDueToWrongExpression() {
		PostfixEvaluator postfixEvaluatorInstance = new PostfixEvaluator(
				"3 2 * 2 ^ 5 3 - 8 4 / *");
		postfixEvaluatorInstance.postfixEvaluation();
		PostfixEvaluator postfixEvaluatorInstanceTwo = new PostfixEvaluator(
				"3 * ");
		postfixEvaluatorInstanceTwo.postfixEvaluation();
	}
}
