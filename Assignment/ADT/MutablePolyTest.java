import static org.junit.Assert.*;

import org.junit.Test;


public class MutablePolyTest {
    @Test
    public void testEvaluateMethod() {
    	
        MutablePoly polynomial = new MutablePoly();
        polynomial.addPolynomial(new Polynomial(3, 2));
        polynomial.addPolynomial(new Polynomial(2, 1));
        polynomial.addPolynomial(new Polynomial(5, 0));
        assertEquals(21.0, polynomial.evaluate(2),0.0);
    }
    @Test
    public void testDegreeMethod() {
    	MutablePoly polynomial = new MutablePoly();
        polynomial.addPolynomial(new Polynomial(3, 5));
        polynomial.addPolynomial(new Polynomial(2, 3));
        polynomial.addPolynomial(new Polynomial(5, 1));
        assertEquals(5, polynomial.degree());
    }

}
