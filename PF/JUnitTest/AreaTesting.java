import static org.junit.Assert.*;

import org.junit.Test;

public class AreaTesting {

    @Test
    public void testArea() {
        Area areaInstance = new Area();
        double areaOfTriangle = areaInstance.areaOfTriangle(2, 12);
        assertEquals(12.0, areaOfTriangle,0.0);
        assertEquals(6.0, areaInstance.areaOfRectangle(2, 3),0.0);
        assertEquals(4.0, areaInstance.areaOfSquare(2),0.0);
    }
}
