import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CounselingProcessOfCollegeImplementation {

	public static void main(String arg[]) throws BiffException, IOException, RowsExceededException, WriteException {
		
		List<Program> programsListOfCollege = new ArrayList<Program>();
		programsListOfCollege = ReadWriteExcel.getListOfProgram();
		Queue<Student> studentQueue = new LinkedList<Student>();
		studentQueue = ReadWriteExcel.getListOfStudents();
		CounselingProcessOfCollege counselingProcessOfCollege = new CounselingProcessOfCollege(
				programsListOfCollege);
		Map<Student, ProgramTypes> studentAndAllocatePrograms = counselingProcessOfCollege
				.counselingProcess(studentQueue);
		ReadWriteExcel.writeResult(studentAndAllocatePrograms);

	}

}
