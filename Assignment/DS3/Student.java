/**
 * This class store information of the student with array of subjects that they
 * want(arrange in according to their priority)
 * 
 * @author Rachna Jadam
 *
 */
public class Student {
	private final String name;
	private static int tempId = 0;
	private final int id;
	private final int maximumNumberOfProgram = 5;
	private ProgramTypes[] programOptions;

	public Student(String name, ProgramTypes[] programOptions) {
		this.name = name;
		this.programOptions = new ProgramTypes[maximumNumberOfProgram];
		id = ++tempId;
		for (int index = 0; index < programOptions.length
				&& index < maximumNumberOfProgram; index++) {
			this.programOptions[index] = programOptions[index];
		}
		// we take index of array as a priority of programs lower the value
		// higher the priority
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public ProgramTypes getProgramOptionsByPriority(int priority) {
		return programOptions[priority];
	}

	public int getMaximumNumberOfProgram() {
		return programOptions.length;
	}
}
