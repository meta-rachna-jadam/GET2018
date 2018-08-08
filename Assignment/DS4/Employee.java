package question1;

public class Employee implements Comparable<Employee>
{
    private final String id;
    private final String name;
    private String address;
    
    /**
     * Initializes Employee object
     * @param id employee id
     * @param name 
     * @param address
    */
    public Employee(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    /**
     * Returns employee id
     * @return employee id
    */
    public String getId(){
        return id;
    }
    
    /**
     * Returns employee name
     * @return employee name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns employee address
     * @return employee address
    */
    public String getAddress() {
        return address;
    }
    
    /**
     * Compares employee id
    */
    @Override
    public int compareTo(Employee employee) {
        return (this.id.compareToIgnoreCase(employee.id));
    }
}
