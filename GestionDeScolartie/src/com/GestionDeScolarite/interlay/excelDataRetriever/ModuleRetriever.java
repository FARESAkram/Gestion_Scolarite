package com.GestionDeScolarite.interlay.excelDataRetriever;

import com.GestionDeScolarite.buisiness.models.Matiere;
import com.GestionDeScolarite.buisiness.models.Module;
import com.GestionDeScolarite.utils.DateFormatter;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import com.GestionDeScolarite.utils.enums.Type;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.List;
import java.util.*;

public class ModuleRetriever extends ExcelDataRetriever<Module>{

    @Override
    public List<Module> getData(Filiere filiere, Niveau niveau) throws IOException {
        XSSFSheet xssfSheet = ExcelDataRetriever.getSheet(filiere, niveau, Type.MODULE);
        return getModules(xssfSheet);
    }

    /**
     * return the list of modules in the given Sheet
     * @param xssfSheet
     * @return List
     */
    private List<Module> getModules(XSSFSheet xssfSheet){
        Iterator<Row> rowIterator = xssfSheet.iterator();
        Row row = rowIterator.next();
        List<Module> modules = new ArrayList<>();
        while ( rowIterator.hasNext() )
        {
            row = rowIterator.next();
            Module module = new Module();
            int index = 0 ;
            if ( row.getCell(index) != null )
            {
                module.setCode(row.getCell(index).getStringCellValue());
                module.setNom(row.getCell(index+1).getStringCellValue());
                Matiere matiere = new Matiere(),matiere2 = new Matiere();
                matiere.setNom(row.getCell(index+2).getStringCellValue());
                matiere2.setNom(row.getCell(index+3).getStringCellValue());
                module.setMatieres(new ArrayList<>(List.of(matiere,matiere2)));
                module.setDepartement(row.getCell(index+4).getStringCellValue());
                modules.add(module);
            }
        }
        return modules;
    }
}
