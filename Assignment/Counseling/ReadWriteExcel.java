
import java.util.*;
import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * This class is use to read from excel file and write into excel file
 * @author Rachna Jadam
 *
 */
public class ReadWriteExcel {
       
    /**
     * This method return list of students by read it from D:\StudentList.xls
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static Queue<Student> getListOfStudents() throws BiffException, IOException
    {
        Workbook workbook=Workbook.getWorkbook(
                new File("D:\\StudentList.xls"));
        Sheet studentSheet=workbook.getSheet(0);
        String program;
        String name;
        Queue<Student> studentQueue=new LinkedList<Student>();
        for(int i=0;i<studentSheet.getRows();i++)
        {
            Cell cell=studentSheet.getCell(0, i);
            name=cell.getContents();
            ProgramTypes[] preferences=new ProgramTypes[5];
            for(int j=0;j<preferences.length;j++)
            {
                cell=studentSheet.getCell(j+1, i);
                program = cell.getContents().toUpperCase();
                if ("CS".equals(program)) {
            	    preferences[j]=ProgramTypes.CS;  
                }else if ("CHEMICAL".equals(program)) {
            	    preferences[j]=ProgramTypes.CHEMICAL;  
                }else if ("CIVEL".equals(program)) {
               	    preferences[j]=ProgramTypes.CIVEL;  
                }else if ("EC".equals(program)) {
               	    preferences[j]=ProgramTypes.EC;  
                }else if ("EE".equals(program)) {
            	    preferences[j]=ProgramTypes.EE;  
                }else if ("EEE".equals(program)) {
            	    preferences[j]=ProgramTypes.EEE;  
                }else if ("EIC".equals(program)) {
            	    preferences[j]=ProgramTypes.EIC;  
                }else if ("ME".equals(program)) {
            	    preferences[j]=ProgramTypes.ME;  
                }else if ("IT".equals(program)) {
            	    preferences[j]=ProgramTypes.IT;  
                }   
            }
            Student student = new Student(name, preferences);
            studentQueue.add(student);
        }
        return studentQueue;
    }
   
    /**
     * This method return list of programs by read it from D:\ProgramList.xls
     * @return
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static List<Program> getListOfProgram() throws BiffException, IOException
    {
        Workbook workbook=Workbook.getWorkbook(
                new File("D:\\ProgramList.xls"));
        Sheet programSheet=workbook.getSheet(0);
        String program;
        List<Program> listOfProgram=new ArrayList<Program>();
        for(int i=0;i<programSheet.getRows();i++)
        {   
            Cell cell=programSheet.getCell(0,i);
            ProgramTypes name = null;
            program = cell.getContents().toUpperCase();
           
            if ("CS".equals(program)) {
        	    name=ProgramTypes.CS;  
            }else if ("CHEMICAL".equals(program)) {
        	    name=ProgramTypes.CHEMICAL;  
            }else if ("CIVEL".equals(program)) {
        	    name=ProgramTypes.CIVEL;  
            }else if ("EC".equals(program)) {
        	    name=ProgramTypes.EC;  
            }else if ("EE".equals(program)) {
         	    name=ProgramTypes.EE;  
            }else if ("EEE".equals(program)) {
        	    name=ProgramTypes.EEE;  
            }else if ("EIC".equals(program)) {
        	    name=ProgramTypes.EIC;  
            }else if ("ME".equals(program)) {
        	    name=ProgramTypes.ME;  
            }else if ("IT".equals(program)) {
        	    name=ProgramTypes.IT;  
            }
            cell=programSheet.getCell(1,i);
            int capacity=Integer.parseInt(cell.getContents());
            Program programInstance = new Program(name, capacity);
            listOfProgram.add(programInstance);  
        }
        return listOfProgram;
    }
   
    /**
     * This method is use to write result in excel file at location D:\studentWorkbook.xls
     * @param finalResult
     * @throws RowsExceededException
     * @throws WriteException
     * @throws IOException
     */
    public static void writeResult(Map<Student, ProgramTypes> finalResult) throws RowsExceededException, WriteException, IOException {
        WritableWorkbook studentWorkbook = Workbook
		        .createWorkbook(new File("D:\\studentWorkbook.xls"));
        WritableSheet studentWorkbookSheet = studentWorkbook.createSheet(
                "sheet1", 0);

        int rowNumber = 1;
        for (Map.Entry<Student, ProgramTypes> mapEntry : finalResult
                .entrySet()) {
             Label l1 = new Label(0, rowNumber, mapEntry.getKey().getName());
             studentWorkbookSheet.addCell(l1);

             Label l2 = new Label(1, rowNumber,  mapEntry.getValue().name());
             studentWorkbookSheet.addCell(l2);
             rowNumber++;
         }
		
         studentWorkbook.write();
         studentWorkbook.close();
    }
}
