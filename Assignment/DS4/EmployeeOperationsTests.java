package question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeOperationsTests {

EmployeeOperations employeeOperations = new EmployeeOperations();
    
    @Before
    public void initialize() {
        employeeOperations.addEmployee("E17/1001", "Rachna", "Jaipur");
        employeeOperations.addEmployee("E18/1021", "Akash", "Noida");
        employeeOperations.addEmployee("E19/1032", "Sonu", "Ajmer");
        employeeOperations.addEmployee("E18/1061", "Yashi", "Kota");
        employeeOperations.addEmployee("E16/1999", "Neha", "Ajmer");
    }
    
    @Test
    public void testAAddEmployeeReturnTrueIfAddSuccessfully() {
        assertTrue(employeeOperations.addEmployee("E16/2096", "Rageeni", "Delhi"));
    }
    
    @Test (expected = AssertionError.class)
    public void testBAddEmployeeWithDuplicateIDThrowAnException(){
        employeeOperations.addEmployee("E16/1999", "Heena", "Alwar");
    }
    
    @Test (expected = AssertionError.class)
    public void testCAddEmployeeWithNullEmployeeIdThrowAnException(){
        employeeOperations.addEmployee(null, "Heena", "Alwar");
    }
    
    @Test (expected = AssertionError.class)
    public void testDAddEmployeeWithNullEmployeeNameThrowAnException(){
        employeeOperations.addEmployee("E16/1939", null, "Alwar");
    }
    
    @Test (expected = AssertionError.class)
    public void testEAddEmployeeWithNullEmployeeAddressThrowAnException(){
        employeeOperations.addEmployee("E16/1000", "Heena", null);
    }
    
    @Test
    public void testFSortByNameReturnSortedListOfEmployeeAccordingToTheirName() {
        String[] expectedOutput = {"Akash", "Neha", "Rachna", "Sonu","Yashi"};
        String[] actualOutput = new String[expectedOutput.length];
        int index = 0;
        for (Employee employee : employeeOperations.sortByName()) {
        	System.out.println(employee.getName());
            actualOutput[index] = employee.getName();
            index++;
        }
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGSortByIDReturnSortedListOfEmployeeAccordingToTheirId() {
    	String[] expectedOutput = {"E16/1999", "E17/1001", "E18/1021", "E18/1061","E19/1032"};
    	String[] actualOutput = new String[expectedOutput.length];
        int index = 0;
        for (Employee employee : employeeOperations.sortById()) {
            actualOutput[index] = employee.getId();
            index++;
        }
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
