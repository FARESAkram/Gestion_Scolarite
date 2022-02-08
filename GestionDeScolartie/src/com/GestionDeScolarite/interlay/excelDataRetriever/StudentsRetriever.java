package com.GestionDeScolarite.interlay.excelDataRetriever;

import com.GestionDeScolarite.buisiness.models.Student;
import com.GestionDeScolarite.utils.DateFormatter;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import com.GestionDeScolarite.utils.enums.Type;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.binary.XSSFBUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;

import java.io.IOException;
import java.util.*;

public class StudentsRetriever extends ExcelDataRetriever<Student>
{
    @Override
    public List<Student> getData(Filiere filiere, Niveau niveau) throws IOException
    {
        XSSFSheet xssfSheet = ExcelDataRetriever.getSheet(filiere, niveau, Type.STUDENT);
        return getStudents(xssfSheet);
    }

    /**
     * get all the students from the sheet passed in arguments
     * @param xssfSheet
     * @return List
     */
    private List<Student> getStudents(XSSFSheet xssfSheet)
    {
        Iterator<Row> rowIterator = xssfSheet.iterator();
        Row row = rowIterator.next();
        List<Student> students = new ArrayList<>();
        while ( rowIterator.hasNext() )
        {
            row = rowIterator.next();
            Student student = new Student();
            int index = 0 ;
            if ( row.getCell(index) != null )
            {
                student.setCne(row.getCell(index).getStringCellValue());
                student.setFirstName(row.getCell(index+1).getStringCellValue());
                student.setLastName(row.getCell(index+2).getStringCellValue());
                student.setDateOfBirth(row.getCell(index+3).getDateCellValue());
                student.setClasseName(row.getCell(index+4).getStringCellValue());
                student.setPhone(row.getCell(index+5).getStringCellValue());
                student.setEmail(row.getCell(index+6).getStringCellValue());
                students.add(student);
            }
        }
        return students;
    }
}
