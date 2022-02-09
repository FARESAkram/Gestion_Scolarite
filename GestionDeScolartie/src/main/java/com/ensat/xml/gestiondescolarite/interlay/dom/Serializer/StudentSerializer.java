package com.ensat.xml.gestiondescolarite.interlay.dom.Serializer;

import com.ensat.xml.gestiondescolarite.buisiness.Retriever;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.utils.DateFormatter;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ensat.xml.gestiondescolarite.buisiness.Paths.ABSOLUTE_PATH;
import static com.ensat.xml.gestiondescolarite.buisiness.Paths.STUDENTS_XML_PATH;

public class StudentSerializer extends XmlSerializer<Student>
{
    private static final String STUDENT_ROOT = "student";

    private static final String FIRST_NAME_ELEMENT = "firstName";
    private static final String LAST_NAME_ELEMENT = "lastName";
    private static final String DATE_OF_BIRTH_ELEMENT = "dateOfBirth";
    private static final String CLASS_NAME_ELEMENT = "className";
    private static final String PHONE_ELEMENT = "phone";
    private static final String EMAIL_ELEMENT = "email";

    private static final String CNE_ATTRIBUT = "CNE";
    private static final String CLASS_ATTRIBUT = "class";

    public StudentSerializer(Filiere filiere, Niveau niveau, Retriever<Student> retriever) throws IOException
    {
        super(filiere, niveau, retriever);
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
    @Override
    protected void setRoot(List<Student> students) throws IOException
    {
        String rootName = STUDENT_ROOT+"s";
        List<Element> elements = new ArrayList<>();
        Element element = domElement.creatElement(rootName,null,CLASS_ATTRIBUT,filiere.toString()+niveau.toString());
        for(Student student:students)
        {
            elements.add(getStudentRow(student));
        }
        domElement.fill(element,elements);
        super.root = element;
        document.appendChild(super.root);
        outputFileName = STUDENT_ROOT+"s_"+filiere.toString()+niveau.toString();
    }
    private Element getStudentRow(Student student) throws IOException
    {
        Element root = domElement.creatElement(STUDENT_ROOT, null, CNE_ATTRIBUT, student.getCne());
        Element firstName = domElement.creatElement(FIRST_NAME_ELEMENT,student.getFirstName());
        Element lastName = domElement.creatElement(LAST_NAME_ELEMENT,student.getLastName());
        Element DateofBirth = domElement.creatElement(DATE_OF_BIRTH_ELEMENT, DateFormatter.format(student.getDateOfBirth()));
        Element ClassName = domElement.creatElement(CLASS_NAME_ELEMENT,student.getClasseName());
        Element Phone = domElement.creatElement(PHONE_ELEMENT,student.getPhone());
        Element Email = domElement.creatElement(EMAIL_ELEMENT,student.getEmail());
        domElement.fill(root,firstName,lastName,DateofBirth,ClassName,Phone,Email);
        return root;
    }
    private void setRootForAll() throws IOException
    {
        StudentSerializer tempo;
        Element e1,e2,e3,temp_root ;
        if ( filiere == Filiere.AP )
        {
            try
            {
                tempo = new StudentSerializer(filiere,Niveau.UN,retriever);
                tempo.setRoot(retriever.getData(Filiere.AP,Niveau.UN));
                e1 = (Element) document.importNode(tempo.getRoot(),true);

                tempo = new StudentSerializer(filiere,Niveau.DEUX,retriever);
                tempo.setRoot(retriever.getData(Filiere.AP,Niveau.DEUX));
                e2 = (Element) document.importNode(tempo.getRoot(),true);

                temp_root = document.createElement(root.toString());
                domElement.fill(temp_root,e1,e2);
                document.appendChild(temp_root);
                outputFileName = STUDENT_ROOT+"s_"+filiere.toString();
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
                tempo = new StudentSerializer(filiere,Niveau.UN,retriever);
                tempo.generateXMLFile();
                e1 = (Element) document.importNode(tempo.getRoot(),true) ;

                tempo = new StudentSerializer(filiere,Niveau.DEUX,retriever);
                tempo.generateXMLFile();
                e2 = (Element) document.importNode(tempo.getRoot(),true);

                tempo = new StudentSerializer(filiere,Niveau.TROIS,retriever);
                tempo.generateXMLFile();
                e3 = (Element) document.importNode(tempo.getRoot(),true);

                Element rootFiliere = domElement.creatElement("all_"+STUDENT_ROOT+"s",null,"Filiere",filiere.toString());

                domElement.fill(rootFiliere,e1,e2,e3);
                document.appendChild(rootFiliere);
                outputFileName = "all_"+STUDENT_ROOT+"s_"+filiere.toString();
            }
            catch (DOMException e)
            {
                throw new IOException(SERVER_ERROR_MESSAGE);
            }

        }
    }

    @Override
    protected String getOutputPath() {
        return ABSOLUTE_PATH+STUDENTS_XML_PATH;
    }
}
