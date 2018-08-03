import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * counseling process of a College
 * 
 * @author Rachna Jadam
 *
 */
public class CounselingProcessOfCollege {
	private Map<ProgramTypes, Integer> nameAndCapacityOfProgram;

	public CounselingProcessOfCollege(List<Program> programList)
			throws AssertionError {
		if (programList == null) {
			throw new AssertionError();
		}
		this.nameAndCapacityOfProgram = new HashMap<ProgramTypes, Integer>();
		for (Program program : programList) {
			this.nameAndCapacityOfProgram.put(program.getName(),
					program.getMaximumSeats());
		}
	}

	/**
	 * this method show how programs are allocated to students according to
	 * seats availablity and their priority
	 * 
	 * @param studentList
	 *            list of student according to their rank, first rank come first
	 * @return
	 */
	public Map<Student, ProgramTypes> counselingProcess(
			List<Student> studentList) {
		int totalAllocatedSeats = 0;
		int totalSeatsInCollege = totalSeatsInCollege();
		Map<Student, ProgramTypes> studentAndAllocatePrograms = new HashMap<Student, ProgramTypes>();
		for (Student student : studentList) {
			for (int programNumber = 0; programNumber < student
					.getMaximumNumberOfProgram(); programNumber++) {
				if (nameAndCapacityOfProgram.containsKey(student
						.getProgramOptionsByPriority(programNumber))) {
					if ((nameAndCapacityOfProgram.get(student
							.getProgramOptionsByPriority(programNumber))) > 0) {
						studentAndAllocatePrograms.put(student, student
								.getProgramOptionsByPriority(programNumber));
						nameAndCapacityOfProgram
								.put(student
										.getProgramOptionsByPriority(programNumber),
										nameAndCapacityOfProgram.get(student
												.getProgramOptionsByPriority(programNumber)) - 1);
						totalAllocatedSeats++;
						break;
					}
				}
			}
			if (totalAllocatedSeats == totalSeatsInCollege) {
				break;
			}
		}
		return studentAndAllocatePrograms;
	}

	/**
	 * this method is use to count total seats available in a college. It count
	 * seats of each branch and return total seats.
	 * 
	 * @return total seats of a college
	 */
	private int totalSeatsInCollege() {
		int totalSeats = 0;
		List<Integer> listOfSeats = new ArrayList<Integer>(
				nameAndCapacityOfProgram.values());

		for (Integer value : listOfSeats) {
			totalSeats += value;
		}
		return totalSeats;
	}

}
