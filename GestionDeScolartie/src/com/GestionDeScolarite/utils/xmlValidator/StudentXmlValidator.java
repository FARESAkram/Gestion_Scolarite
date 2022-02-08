package com.GestionDeScolarite.utils.xmlValidator;

import com.GestionDeScolarite.buisiness.models.Student;
import com.GestionDeScolarite.interlay.daos.DaoException;
import com.GestionDeScolarite.utils.Paths.*;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import com.GestionDeScolarite.utils.enums.Type;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import static com.GestionDeScolarite.utils.Paths.*;

public class StudentXmlValidator extends XmlValidator<Student>
{
    @Override
    protected String filePath(Filiere filiere, Niveau niveau ,String extension)
    {
        if ( extension == XML_EXTENSION )
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
