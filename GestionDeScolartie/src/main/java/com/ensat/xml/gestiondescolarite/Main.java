package com.ensat.xml.gestiondescolarite;

import com.ensat.xml.gestiondescolarite.buisiness.models.Module;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.NoteSerializer;
import com.ensat.xml.gestiondescolarite.buisiness.Serializer;
import com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever.NotesRetriever;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import java.util.List;
import java.util.Map;

import static com.ensat.xml.gestiondescolarite.buisiness.services.htmlGenerators.HtmlAffichageGenerator.generateAvantRatt;

public class Main
{
    public static Boolean DISABLE_WARNING = false;
    public static void main(String[] args)
    {
        disableWarning(DISABLE_WARNING);

        try
        {
            /*Serializer<Professor> entrySerializer = new ProfessorSerializer(
                    new ProfessorsRetriever()
            );
            entrySerializer.serialize();*/
            /*Serializer<Module> moduleSerializer = new ModuleSerializer(
                    Filiere.GINF, Niveau.DEUX,new ModuleRetriever()
            );
            moduleSerializer.serialize();*/
            /*Serializer<Student> studentSerializer = new StudentSerializer(
                    Filiere.GINF, Niveau.DEUX,new StudentsRetriever()
            );
            studentSerializer.serialize();*/
            Serializer<Map.Entry<Module, List<Student>>> noteSerializer = new NoteSerializer(
                    Filiere.GINF, Niveau.DEUX,new NotesRetriever()
            );
            noteSerializer.serialize();
            /*Retriever<Map.Entry<Module,List<Student>>> studentRetriever = new NotesRetriever();
            studentRetriever.getData();*/
            /*Validator<Professor> validator = new ProfessorXmlValidator();
            validator.validate(Filiere.GINF, Niveau.DEUX);
            System.out.println("XML is Valid");*/
            generateAvantRatt(Filiere.GINF,Niveau.DEUX,"GINF31");
        }
        catch (Exception e)
        {
            e.printStackTrace();
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
