package com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever;

import com.ensat.xml.gestiondescolarite.buisiness.models.Module;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import com.ensat.xml.gestiondescolarite.utils.enums.Type;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.util.*;


public class NotesRetriever extends ExcelDataRetriever<Map.Entry<Module, List<Student>>>
{
    private List<Module> modules;
    private List<Student> students;

    /**
     * Retrieve the grades of all students for every subject
     * @param filiere
     * @paramn niveau
     * @return List
     */
    @Override
    public List<Map.Entry<Module, List<Student>>> getData(Filiere filiere, Niveau niveau) throws IOException
    {
        XSSFSheet xssfSheet = getSheet(filiere,niveau, Type.NOTE);
        students = new StudentsRetriever().getData(filiere,niveau);
        modules = new ModuleRetriever().getData(filiere,niveau);
        List<Map.Entry<Module, List<Student>>> res = new ArrayList<>();
        List<Student> moduleStudents = getNotes(xssfSheet);
        for ( Module module: modules)
        {
            for ( Student student:students)
            {
                if ( student.getNotes().containsKey(module) )
                    moduleStudents.add(student);
            }
            Map.Entry<Module, List<Student>> entry = new AbstractMap.SimpleEntry<>(module,moduleStudents);
            res.add(entry);
        }
        return res;
    }

    /**
     * get all marks from the file
     * @param xssfSheet
     * @return Map
     */
    private List<Student> getNotes(XSSFSheet xssfSheet)
    {
        List<Student> notes = new ArrayList<>();
        Iterator<Row> rowIterator = xssfSheet.iterator();
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator ;
        while ( rowIterator.hasNext() )
        {
            row = rowIterator.next();
            cellIterator = row.cellIterator();
            int index = 0 ;
            if ( row.getCell(index) != null )
            {
                Student student = getStudent(row.getCell(index+1).getStringCellValue());
                Module module = getModule(row.getCell(index+2).getStringCellValue());
                double note = row.getCell(index+4).getNumericCellValue();
                if ( notes.contains(student) )
                {
                    Map<Module,Double> studentMarks = notes.get(notes.indexOf(student)).getNotes();
                    if ( studentMarks.containsKey(module) )
                    {
                        studentMarks.put(module,(studentMarks.get(module)+note)/2.0);
                    }
                    else
                    {
                        studentMarks.put(module,note);
                    }
                }
                else
                {
                    Map<Module,Double> studentMarks = new HashMap<>();
                    studentMarks.put(module,note);
                    student.setNotes(studentMarks);
                }
                notes.add(student);
            }
        }
        return notes;
    }

    /**
     * return the student from the list by cne
     * or null if does not exist
     * @param cne
     * @return
     */
    private Student getStudent(String cne)
    {
        Student student = new Student();
        student.setCne(cne);
        if ( students.contains(student) )
            return students.get(students.indexOf(student));
        return null;
    }

    /**
     * return the module from the list by code
     * or null if it does not exist
     * @param code
     * @return
     */
    private Module getModule(String code)
    {
        Module module = new Module();
        module.setCode(code);
        if(modules.contains(module))
            return modules.get(modules.indexOf(module));
        return null;
    }
    /*private void initialize()
    {
        for (Module module:modules)
        {
            for(Student student:students)
            {
                student
            }
        }
    }*/
}
