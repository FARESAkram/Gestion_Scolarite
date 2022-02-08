package com.GestionDeScolarite;

import com.GestionDeScolarite.buisiness.Serializer;
import com.GestionDeScolarite.buisiness.models.Professor;
import com.GestionDeScolarite.interlay.daos.DaoException;
import com.GestionDeScolarite.interlay.daos.Validator;
import com.GestionDeScolarite.interlay.dom.Serializer.*;
import com.GestionDeScolarite.interlay.excelDataRetriever.*;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import com.GestionDeScolarite.utils.xmlValidator.StudentXmlValidator;

import java.io.IOException;

public class Main
{
    public static Boolean DISABLE_WARNING = false;
    public static void main(String[] args)
    {
        disableWarning(DISABLE_WARNING);

        try
        {
            Serializer<Professor> entrySerializer = new ProfessorSerializer(
                    new ProfessorsRetriever()
            );
            entrySerializer.serialize();
            /*Retriever<Map.Entry<Module,List<Student>>> studentRetriever = new NotesRetriever();
            studentRetriever.getData();*/
            /*Validator validator = new StudentXmlValidator();
            validator.validate(Filiere.GINF, Niveau.DEUX);*/
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void disableWarning(boolean disable)
    {
        if ( disable )
        {
            System.err.close();
            System.setErr(System.out);
        }
    }
}
