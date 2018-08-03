import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CounselingProcessOfCollegeImplementation {

	public static void main(String arg[]) {
		List<Program> programsListOfCollege = new ArrayList<Program>();
		programsListOfCollege.add(new Program(ProgramTypes.CS, 3));
		programsListOfCollege.add(new Program(ProgramTypes.IT, 2));
		programsListOfCollege.add(new Program(ProgramTypes.EC, 1));
		CounselingProcessOfCollege c = new CounselingProcessOfCollege(
				programsListOfCollege);
		Student studentWithRank8 = new Student("sonal", new ProgramTypes[] {
				ProgramTypes.CS, ProgramTypes.IT, ProgramTypes.EC,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank7 = new Student("heena", new ProgramTypes[] {
				ProgramTypes.EC, ProgramTypes.CS, ProgramTypes.IT,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank6 = new Student("ritika", new ProgramTypes[] {
				ProgramTypes.CS, ProgramTypes.IT, ProgramTypes.EC,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank4 = new Student("pinky", new ProgramTypes[] {
				ProgramTypes.EC, ProgramTypes.CS, ProgramTypes.IT,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank5 = new Student("akash", new ProgramTypes[] {
				ProgramTypes.EC, ProgramTypes.CS, ProgramTypes.IT,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank3 = new Student("rajat", new ProgramTypes[] {
				ProgramTypes.EC, ProgramTypes.CS, ProgramTypes.IT,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank2 = new Student("rageni", new ProgramTypes[] {
				ProgramTypes.CS, ProgramTypes.IT, ProgramTypes.EC,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		Student studentWithRank1 = new Student("rachna", new ProgramTypes[] {
				ProgramTypes.EC, ProgramTypes.CS, ProgramTypes.IT,
				ProgramTypes.CIVEL, ProgramTypes.CHEMICAL });
		List<Student> studentsListr = new ArrayList<Student>();
		studentsListr.add(studentWithRank1);
		studentsListr.add(studentWithRank2);
		studentsListr.add(studentWithRank3);
		studentsListr.add(studentWithRank4);
		studentsListr.add(studentWithRank5);
		studentsListr.add(studentWithRank6);
		studentsListr.add(studentWithRank7);
		studentsListr.add(studentWithRank8);
		Map<Student, ProgramTypes> studentAndAllocatePrograms = c
				.counselingProcess(studentsListr);
		for (Map.Entry<Student, ProgramTypes> mapEntry : studentAndAllocatePrograms
				.entrySet()) {
			System.out.print(mapEntry.getKey().getName());
			System.out.print("\t" + mapEntry.getValue().name());
			System.out.println();
		}

	}

}
