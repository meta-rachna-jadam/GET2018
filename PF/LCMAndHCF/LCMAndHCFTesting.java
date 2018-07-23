import static org.junit.Assert.*;

import org.junit.Test;


public class LCMAndHCFTesting {

    @Test
    public void testLCM() {
        LCMAndHCF lcmAndHCFInstace = new LCMAndHCF();
        int lcm = lcmAndHCFInstace.findLCM(12, 18);
        assertEquals(36, lcm);
    }
    @Test
    public void testHCF() {
        LCMAndHCF lcmAndHCFInstace = new LCMAndHCF();
        int hcf = lcmAndHCFInstace.findHCF(12, 18);
        assertEquals(6, hcf);
    }
}
