import static org.junit.Assert.*;
import org.junit.Test;

public class FCFSTesting {

    @Test
    public void testFCFS() {
        FirstComeFirstServeScheduling firstComeFirstServeSchedulingInstace = new FirstComeFirstServeScheduling(new int[][]{{0,4},{2,3},{3,4},{5,8}});
        assertEquals(7, firstComeFirstServeSchedulingInstace.calculateCompletionTime(2));
        assertEquals(8, firstComeFirstServeSchedulingInstace.calculateTurnAroundTime(3));
        assertEquals(6, firstComeFirstServeSchedulingInstace.calculateWaitingTime(4));
        assertEquals(3.0, firstComeFirstServeSchedulingInstace.calculateAverageWaitingTime(),0.0);
        assertEquals(6, firstComeFirstServeSchedulingInstace.calculateMaxWaitingTime());
    }

}
