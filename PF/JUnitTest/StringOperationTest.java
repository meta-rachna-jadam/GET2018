import static org.junit.Assert.*;

import org.junit.Test;


public class StringOperationTest {

    @Test
    public void test() {
        OperationsOnString operationsOnStringInstace = new OperationsOnString();
        assertEquals(1, operationsOnStringInstace.compareTo("Rachna", "Rachna"));
        assertEquals(0, operationsOnStringInstace.compareTo("Rachna", "rachna"));
        assertEquals("rachna", operationsOnStringInstace.toLowerCase("RACHNA"));
        assertEquals("RACHNA", operationsOnStringInstace.toUpperCase("Rachna"));
        assertEquals("Rachna", operationsOnStringInstace.largestWord("Hello Rachna"));
    }
}
