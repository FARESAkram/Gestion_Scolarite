package com.GestionDeScolarite.interlay.excelDataRetriever;

import com.GestionDeScolarite.buisiness.Retriever;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import com.GestionDeScolarite.utils.enums.Type;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.GestionDeScolarite.utils.Paths.*;


public abstract class ExcelDataRetriever<T> implements Retriever<T>
{
    public abstract List<T> getData(Filiere filiere, Niveau niveau) throws IOException;

    private static File getExcelFile(Filiere filiere , Niveau niveau , Type type) throws IOException
    {
        StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
        switch (type)
        {
            case PROF:
                path.append(PROFS_EXCELS_PATH);
                path.append("/");
                path.append(type);
                path.append("s");
                break;
            case MODULE:
                path.append(MODULES_EXCELS_PATH);
                path.append("/");
                path.append(type);
                path.append("_");
                path.append(filiere);
                path.append(niveau);
                break;
            case MATIERE:
                path.append(MATIERES_EXCELS_PATH);
                path.append("/");
                path.append(type);
                break;
            case STUDENT:
                path.append(STUDENTS_EXCELS_PATH);
                path.append("/");
                path.append(type);
                path.append("_");
                path.append(filiere);
                path.append(niveau);
                break;
            case NOTE:
                path.append(NOTES_EXCELS_PATH);
                path.append("/");
                path.append(type);
                path.append("_");
                path.append(filiere);
                path.append(niveau);
                break;
            default:
                throw new IOException("le type que vous cherchez n'existe pas!");
        }
        path.append(EXCEL_EXTENSION);
        return new File(path.toString());
    }
    protected static XSSFSheet getSheet(Filiere filiere , Niveau niveau , Type type) throws IOException
    {
        FileInputStream fileInputStream;
        try
        {
            fileInputStream =new FileInputStream(ExcelDataRetriever.getExcelFile(filiere,niveau,type));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            return xssfWorkbook.getSheetAt(0);
        }
        catch (FileNotFoundException fnfe)
        {
            throw new IOException("Le fichier que vous cherchez n'existe pas");
        }
    }
}
