package com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever;

import com.ensat.xml.gestiondescolarite.buisiness.models.Professor;
import com.ensat.xml.gestiondescolarite.utils.DateFormatter;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import com.ensat.xml.gestiondescolarite.utils.enums.Type;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.util.*;

public class ProfessorsRetriever extends ExcelDataRetriever<Professor>
{
    @Override
    public List<Professor> getData(Filiere filiere, Niveau niveau) throws IOException
    {
        XSSFSheet xssfSheet = ExcelDataRetriever.getSheet(filiere, niveau, Type.PROF);
        return getProfessors(xssfSheet);
    }

    /**
     * get all the professors from the sheet passed in arguments
     * @param  xssfSheet
     * @return List
     */
    private List<Professor> getProfessors(XSSFSheet xssfSheet)
    {
        Iterator<Row> rowIterator = xssfSheet.iterator();
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator() ;
        List<Professor> professors = new ArrayList<>();
        while ( rowIterator.hasNext() )
        {
            row = rowIterator.next();
            cellIterator = row.cellIterator();
            Professor professor = new Professor();
            int index = 1 ;
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellTypeEnum() )
                {
                    case STRING:
                        fill(professor,index++,cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        fill(professor,index++, DateFormatter.format(cell.getDateCellValue()));
                        break;
                    case BLANK:
                        fill(professor,index++,"");
                        break;
                    case BOOLEAN:
                        fill(professor,index++,String.valueOf(cell.getBooleanCellValue()));
                        break;
                    default:
                        fill(professor,index++,"Invalid Type");
                }
            }
            professors.add(professor);
        }
        return professors;
    }
    /**
     * fill the professor with the value given at the index
     * @param professor
     * @param index
     * @param value
     */
    private void fill(Professor professor, int index, String value)
    {
        switch (index)
        {
            case 1:
                professor.setCin(value);
                break;
            case 2:
                professor.setFirstName(value);
                break;
            case 3:
                professor.setLastName(value);
                break;
            case 4:
                professor.setDepartement(value);
                break;
            case 5:
                professor.setPhone(value);
                break;
            case 6:
                professor.setEmail(value);
                break;
        }
    }

}
