import java.util.ArrayList;
import java.util.List;

public class Marksheet {
	private List<Student> studentList;
	public Marksheet() {
		studentList = new ArrayList<Student>();
	}
	
	/**
	 * Use to add a new student in a studentList
	 * @param studentInstance Student type object
	 * @throws IllegalArgumentException when grade is not in range, range of grade if 0-100
	 */
	public void addStudent(Student studentInstance) throws IllegalArgumentException{
		if((studentInstance.getGrade() > 0) && (studentInstance.getGrade() < 100)){
			roundOfUptoTwoDecimalPlaces(studentInstance.getGrade());
			studentList.add(studentInstance);
		}
		else{
			throw new IllegalArgumentException();
		}	
	}
	
	/**
	 * Calculate average of grades
	 * @return average of grade
	 */
	public float averageOfGrades(){
		float totalOfGrades=0;
		float averageOfGrades;
		for(int index = 0 ; index < studentList.size() ; index++)
		{
			totalOfGrades += studentList.get(index).getGrade();
		}
		averageOfGrades = roundOfUptoTwoDecimalPlaces(totalOfGrades/studentList.size());
		return averageOfGrades;
	}
	
	/**
	 * Calculate maximum grades
	 * @return maximum grade
	 */
	public float getMaximumGrade(){
	    float maximum = studentList.get(0).getGrade();
		for(int index = 1 ; index < studentList.size() ; index++){
			if(studentList.get(index).getGrade() > maximum){
				maximum = studentList.get(index).getGrade();
			}
		}
		return maximum;
	}
	
	/**
	 * Calculate minimum grades
	 * @return minimum grade
	 */
	public float getMinimumGrade(){
	    float minimum = studentList.get(0).getGrade();
		for(int index = 1 ; index < studentList.size() ; index++){
			if(studentList.get(index).getGrade() < minimum){
				minimum = studentList.get(index).getGrade();
			}
		}
		return minimum;
	}
	
	/**
	 * Calculate percentage of pass students
	 * @return percentage of pass students, student pass if his/her grade is greater then or equal to 40
	 */
	public float getPercentageOfPassStudents(){
		float totalNumberOfPassStudent=0;
		float percentageOfPassStudents;
		for (int index = 0; index < studentList.size(); index++) {
			if(studentList.get(index).getGrade() >= 40){
				totalNumberOfPassStudent++;
			}
		}
		percentageOfPassStudents = (totalNumberOfPassStudent*100)/(studentList.size());
		return roundOfUptoTwoDecimalPlaces(percentageOfPassStudents);
	}
	
	float roundOfUptoTwoDecimalPlaces(float value)
	{
	    return Float.parseFloat(String.format("%.2f", value));
	}
}
