package com.GestionDeScolarite.interlay.dom.Serializer;

import com.GestionDeScolarite.buisiness.Retriever;
import com.GestionDeScolarite.buisiness.models.Professor;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.GestionDeScolarite.utils.Paths.ABSOLUTE_PATH;
import static com.GestionDeScolarite.utils.Paths.PROFS_XML_PATH;

public class ProfessorSerializer extends XmlSerializer<Professor>
{
    private static final String PROFESSOR_ROOT = "Professor";

    private static final String FIRST_NAME_ELEMENT = "firstName";
    private static final String LAST_NAME_ELEMENT = "lastName";
    private static final String DEPARTEMENT_ELEMENT = "departement";
    private static final String PHONE_ELEMENT = "phone";
    private static final String EMAIL_ELEMENT = "email";

    private static final String CIN_ATTRIBUT = "CIN";
    private static final String CLASS_ATTRIBUT = "class";

    public ProfessorSerializer(Retriever<Professor> retriever) throws IOException {
        super(Filiere.GINF,Niveau.UN,retriever);

    }
    private ProfessorSerializer(Filiere filiere, Niveau niveau, Retriever<Professor> retriever) throws IOException {
        super(filiere, niveau, retriever);
    }

    @Override
    protected void setRoot(List<Professor> professors) throws IOException
    {
        String rootName = PROFESSOR_ROOT +"s";
        List<Element> elements = new ArrayList<>();
        Element element = domElement.creatElement(rootName);
        for(Professor professor:professors)
        {
            elements.add(getProfessorRow(professor));
        }
        domElement.fill(element,elements);
        super.root = element;
        document.appendChild(super.root);
        outputFileName = PROFESSOR_ROOT +"s";
    }
    private Element getProfessorRow(Professor professor) throws IOException
    {
        Element root = domElement.creatElement(PROFESSOR_ROOT, null, CIN_ATTRIBUT, professor.getCin());
        Element firstName = domElement.creatElement(FIRST_NAME_ELEMENT,professor.getFirstName());
        Element lastName = domElement.creatElement(LAST_NAME_ELEMENT,professor.getLastName());
        Element departement = domElement.creatElement(DEPARTEMENT_ELEMENT, professor.getDepartement());
        Element Phone = domElement.creatElement(PHONE_ELEMENT,professor.getPhone());
        Element Email = domElement.creatElement(EMAIL_ELEMENT,professor.getEmail());
        domElement.fill(root,firstName,lastName,departement,Phone,Email);
        return root;
    }

    @Override
    protected void generateXMLFile() throws IOException {
        setRoot(retriever.getData(filiere,niveau));
    }

    @Override
    protected String getOutputPath() {
        return ABSOLUTE_PATH+PROFS_XML_PATH;
    }
}
