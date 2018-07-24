import static org.junit.Assert.*;

import org.junit.Test;


public class PolyTest {

    @Test
    public void testEvaluateMethod() {
        Poly polynomial = new Poly(new int[][]{{3,2},{2,1},{5,0}});
        assertEquals(21.0, polynomial.evaluate(2),0.0);
    }
    @Test
    public void testDegreeMethod() {
        Poly polynomial = new Poly(new int[][]{{3,2},{2,1},{5,0}});
        assertEquals(2, polynomial.degree());
    }
}
