import static org.junit.Assert.*;

import org.junit.Test;

public class MarksheetProjectTesting {

    @Test
    public void test() {
        Marksheet marksheetInstace = new Marksheet();
        marksheetInstace.addStudent(new Student("Rachna", 98.9f));
        marksheetInstace.addStudent(new Student("Rajat", 94.9f));
        marksheetInstace.addStudent(new Student("xyz", 34.9f));
        marksheetInstace.addStudent(new Student("abc", 54.23f));
        float averageOfGrades = marksheetInstace.averageOfGrades();
        float maximumGrade = marksheetInstace.getMaximumGrade();
        float minimumGrade = marksheetInstace.getMinimumGrade();
        float percentageOfPassStudents = marksheetInstace.getPercentageOfPassStudents();
        assertEquals(70.73, averageOfGrades, 0.1);
        assertEquals(98.9, maximumGrade, 0.1);
        assertEquals(34.9, minimumGrade, 0.1);
        assertEquals(75.0, percentageOfPassStudents, 0.1);  
    }
}
