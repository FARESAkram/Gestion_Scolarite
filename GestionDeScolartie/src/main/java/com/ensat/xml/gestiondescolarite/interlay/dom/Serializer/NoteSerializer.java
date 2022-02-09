package com.ensat.xml.gestiondescolarite.interlay.dom.Serializer;

import com.ensat.xml.gestiondescolarite.buisiness.Retriever;
import com.ensat.xml.gestiondescolarite.buisiness.models.Module;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ensat.xml.gestiondescolarite.utils.Paths.ABSOLUTE_PATH;
import static com.ensat.xml.gestiondescolarite.utils.Paths.NOTES_XML_PATH;

public class NoteSerializer extends XmlSerializer<Map.Entry<Module, List<Student>>>
{
    private static final String NOTE_ROOT = "note";
    private static final String MODULE_ROOT = "module";
    private static final String STUDENT_ROOT = "student";

    private static final String FIRST_NAME_ELEMENT = "firstName";
    private static final String LAST_NAME_ELEMENT = "lastName";
    private static final String MOYENNE_ELEMENT = "moyenne";

    private static final String CODE_ATTRIBUT = "code";
    private static final String CNE_ATTRIBUT = "CNE";
    private static final String CLASS_ATTRIBUT = "class";

    public NoteSerializer(Filiere filiere, Niveau niveau, Retriever<Map.Entry<Module, List<Student>>> retriever) throws IOException {
        super(filiere, niveau, retriever);
    }

    @Override
    protected void setRoot(List<Map.Entry<Module, List<Student>>> data) throws IOException {
        Element element = domElement.creatElement(NOTE_ROOT,null,CLASS_ATTRIBUT,data.get(0).getValue().get(0).getClasseName());
        domElement.fill(element,getModulesRow(data));
        super.root = element;
        document.appendChild(super.root);
        outputFileName = NOTE_ROOT+"s_"+filiere.toString()+niveau.toString();
    }

    @Override
    protected void generateXMLFile() throws IOException
    {
        if ( niveau == Niveau.TOUS)
        {
            setRootForAll();
        }
        else
        {
            setRoot(retriever.getData(filiere,niveau));
        }
    }
    private void setRootForAll() throws IOException
    {
        NoteSerializer tempo;
        Element e1,e2,e3,temp_root ;
        if ( filiere == Filiere.AP )
        {
            try
            {
                tempo = new NoteSerializer(filiere,Niveau.UN,retriever);
                tempo.setRoot(retriever.getData(Filiere.AP,Niveau.UN));
                e1 = (Element) document.importNode(tempo.getRoot(),true);

                tempo = new NoteSerializer(filiere,Niveau.DEUX,retriever);
                tempo.setRoot(retriever.getData(Filiere.AP,Niveau.DEUX));
                e2 = (Element) document.importNode(tempo.getRoot(),true);

                temp_root = document.createElement(root.toString());
                domElement.fill(temp_root,e1,e2);
                document.appendChild(temp_root);
                outputFileName = NOTE_ROOT+"s_"+filiere.toString();
            }
            catch (FileNotFoundException e)
            {
                throw new IOException(SERVER_ERROR_MESSAGE);
            }
        }
        else
        {
            try
            {
                tempo = new NoteSerializer(filiere,Niveau.UN,retriever);
                tempo.generateXMLFile();
                e1 = (Element) document.importNode(tempo.getRoot(),true) ;

                tempo = new NoteSerializer(filiere,Niveau.DEUX,retriever);
                tempo.generateXMLFile();
                e2 = (Element) document.importNode(tempo.getRoot(),true);

                tempo = new NoteSerializer(filiere,Niveau.TROIS,retriever);
                tempo.generateXMLFile();
                e3 = (Element) document.importNode(tempo.getRoot(),true);

                Element rootFiliere = domElement.creatElement("all_"+NOTE_ROOT+"s",null,"Filiere",filiere.toString());

                domElement.fill(rootFiliere,e1,e2,e3);
                document.appendChild(rootFiliere);
                outputFileName = "all_"+NOTE_ROOT+"s_"+filiere.toString();
            }
            catch (DOMException e)
            {
                throw new IOException(SERVER_ERROR_MESSAGE);
            }

        }
    }

    @Override
    protected String getOutputPath() {
        return ABSOLUTE_PATH+NOTES_XML_PATH;
    }
    private Element getStudentRow(Student student, Module module) throws IOException
    {
        Element root = domElement.creatElement(STUDENT_ROOT,null,CNE_ATTRIBUT,student.getCne());
        Element lastName = domElement.creatElement(LAST_NAME_ELEMENT,student.getLastName());
        Element firstName = domElement.creatElement(FIRST_NAME_ELEMENT,student.getFirstName());
        Element note = domElement.creatElement(MOYENNE_ELEMENT, String.valueOf(student.getNotes().get(module)));
        domElement.fill(root,lastName,firstName,note);
        return root;
    }
    private Element getStudentsRow(List<Student> students,Module module) throws IOException
    {
        List<Element> elements = new ArrayList<>();
        Element root = domElement.creatElement(STUDENT_ROOT+"s");
        for (Student student:students)
        {
            elements.add(getStudentRow(student,module));
        }
        domElement.fill(root,elements);
        return root;
    }
    private Element getModuleRow(List<Student> students,Module module) throws IOException
    {
        Element root = domElement.creatElement(MODULE_ROOT,null,CODE_ATTRIBUT, module.getCode());
        domElement.fill(root,getStudentsRow(students,module));
        return root;
    }
    private Element getModulesRow(List<Map.Entry<Module, List<Student>>> data) throws IOException
    {
        List<Element> elements = new ArrayList<>();
        Element root = domElement.creatElement(MODULE_ROOT+"s");
        for(Map.Entry<Module, List<Student>> entry:data)
        {
            Module module = entry.getKey();
            List<Student> moduleStudents = entry.getValue();
            elements.add(getModuleRow(moduleStudents,module));
        }
        domElement.fill(root,elements);
        return root;
    }
}
