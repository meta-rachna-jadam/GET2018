package question1;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>
{

    @Override
    public int compare(Employee employee1, Employee employee2)
    {
        
        return employee1.getName().compareToIgnoreCase(employee2.getName());
    }
    
}
