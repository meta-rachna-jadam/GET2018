package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeOperations{
    Map<String, Employee> employeeList;
    
    /**
     * Initializes EmployeeOperations
     */
    public EmployeeOperations(){
        employeeList = new HashMap<String, Employee>();
    }
    
    /**
     * Adds employee 
     * @param id unique employee id
     * @param name employee name
     * @param address employee address
     * @return
     */
    public boolean addEmployee(String id, String name, String address) throws AssertionError {
    	if (id == null || name == null || address == null) {
    		throw new AssertionError("Entries can not be null");
    	}else if (employeeList.containsKey(id)) {
    		throw new AssertionError("Employee Id should be unique");
    	} else {
    		employeeList.put(id, new Employee(id, name, address));
    	}
        return true;
    }
    
    /**
     * Returns list of employee sorted by name
     * @return list of employee
     */
    public List<Employee> sortByName(){
        List<Employee> sortedEmployeeList = new ArrayList<Employee>(employeeList.values());
        Collections.sort(sortedEmployeeList, new SortByName());
        return sortedEmployeeList;
    }
    
    /**
     * Returns list of employee sorted by id
     * @return list of employee
     */
    public List<Employee> sortById(){
        List<Employee> sortedEmployeeList = new ArrayList<Employee>(employeeList.values());
        Collections.sort(sortedEmployeeList);
        return sortedEmployeeList;
    }
}