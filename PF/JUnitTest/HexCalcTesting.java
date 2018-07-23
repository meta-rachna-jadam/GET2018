import static org.junit.Assert.*;

import org.junit.Test;


public class HexCalcTesting {

    @Test
    public void decimalToHexadecimalTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals(4666, hexCalcInstance.convertBaseToDecimal("123a"));
    }
    
    @Test
    public void hexadecimalToDecimalTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals("123A", hexCalcInstance.convertDecimalToBase(4666));
    }
    
    @Test
    public void additionTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals("1423", hexCalcInstance.add("8AB","B78"));
    }
    @Test
    public void subtractionlTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals("433", hexCalcInstance.subtract("fAB", "B78"));
    }
    @Test
    public void multiplicationTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals("B3B128", hexCalcInstance.multiply("fAB", "B78"));
    }

    @Test
    public void divisionTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals("1", hexCalcInstance.divide("fAB", "B78"));
    }
   
    @Test
    public void equalityTest() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals(true, hexCalcInstance.isEquals("fa","fa"));
    }
    
    @Test
    public void testForLess() {
        HexCalc hexCalcInstance = new HexCalc();
        assertEquals(true, hexCalcInstance.isLess("f0", "fc"));
    }


   
}
