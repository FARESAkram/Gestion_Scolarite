package com.ensat.xml.gestiondescolarite.utils.xmlValidator;

import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import com.ensat.xml.gestiondescolarite.utils.enums.Type;

import static com.ensat.xml.gestiondescolarite.utils.Paths.*;

public class StudentXmlValidator extends XmlValidator<Student>
{
    @Override
    protected String filePath(Filiere filiere, Niveau niveau ,String extension)
    {
        if ( XML_EXTENSION.equalsIgnoreCase(extension) )
        {
            return xmlFilePath(filiere, niveau);
        }
        else
        {
            return xsdFilePath(filiere, niveau);
        }
    }

    private String xmlFilePath(Filiere filiere, Niveau niveau)
    {
        if ( niveau == Niveau.TOUS)
        {
            StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
            path.append(STUDENTS_XML_PATH);
            path.append("/all_");
            path.append(Type.STUDENT);
            path.append("s_");
            path.append(filiere);
            path.append(XML_EXTENSION);
            return path.toString();
        }
        else
        {
            StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
            path.append(STUDENTS_XML_PATH);
            path.append("/");
            path.append(Type.STUDENT);
            path.append("s_");
            path.append(filiere);
            path.append(niveau);
            path.append(XML_EXTENSION);
            return path.toString();
        }
    }

    private String xsdFilePath(Filiere filiere, Niveau niveau)
    {
        if ( niveau == Niveau.TOUS)
        {
            StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
            path.append(STUDENTS_XML_PATH);
            path.append("/all_");
            path.append(Type.STUDENT);
            path.append("s_");
            path.append(filiere);
            path.append(XSD_EXTENSION);
            return path.toString();
        }
        else
        {
            StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
            path.append(STUDENTS_XML_PATH);
            path.append("/");
            path.append(Type.STUDENT);
            path.append("s_");
            path.append(filiere);
            path.append(niveau);
            path.append(XSD_EXTENSION);
            return path.toString();
        }
    }
}
