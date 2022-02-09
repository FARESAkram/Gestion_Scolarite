package com.ensat.xml.gestiondescolarite.interlay.xmlValidator;

import com.ensat.xml.gestiondescolarite.buisiness.models.Professor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import com.ensat.xml.gestiondescolarite.utils.enums.Type;

import static com.ensat.xml.gestiondescolarite.buisiness.Paths.*;
import static com.ensat.xml.gestiondescolarite.buisiness.Paths.XSD_EXTENSION;

public class ProfessorXmlValidator extends XmlValidator<Professor>
{
    @Override
    protected String filePath(Filiere filiere, Niveau niveau, String extension) {
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
        StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
        path.append(PROFS_XML_PATH);
        path.append("/");
        path.append(Type.STUDENT);
        path.append("s_");
        path.append(filiere);
        path.append(niveau);
        path.append(XML_EXTENSION);
        return path.toString();
    }

    private String xsdFilePath(Filiere filiere, Niveau niveau)
    {
        StringBuilder path = new StringBuilder(ABSOLUTE_PATH);
        path.append(PROFS_XSD_PATH);
        path.append("/");
        path.append(Type.STUDENT);
        path.append("s_");
        path.append(filiere);
        path.append(niveau);
        path.append(XSD_EXTENSION);
        return path.toString();
    }
}
