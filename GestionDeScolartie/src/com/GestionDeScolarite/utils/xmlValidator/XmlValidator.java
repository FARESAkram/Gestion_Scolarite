package com.GestionDeScolarite.utils.xmlValidator;

import com.GestionDeScolarite.interlay.daos.DaoException;
import com.GestionDeScolarite.interlay.daos.Validator;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import com.GestionDeScolarite.utils.Paths;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.GestionDeScolarite.utils.Paths.XML_EXTENSION;
import static com.GestionDeScolarite.utils.Paths.XSD_EXTENSION;

public abstract class XmlValidator<T> implements Validator
{

    public void validate(Filiere filiere, Niveau niveau) throws DaoException
    {
        try
        {
            File xmlFile = getXMLFile(filiere,niveau);
            File xsdFile = getXSDFile(filiere,niveau);
            isValid(xmlFile,xsdFile);
        }
        catch (FileNotFoundException e)
        {
            throw new DaoException("XML or XSD file not found");
        }
        catch (IOException | SAXException e)
        {
            throw new DaoException("XML n'est pas valid");
        }
    }

    private static void isValid(File xmlFile, File xsdFile) throws IOException, SAXException
    {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(new FileInputStream(xsdFile)));
        javax.xml.validation.Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new FileInputStream(xmlFile)));
    }

    private File getXMLFile(Filiere filiere, Niveau niveau)
    {
        return new File(filePath(filiere,niveau,XML_EXTENSION));
    }

    private File getXSDFile(Filiere filiere, Niveau niveau)
    {
        return new File(filePath(filiere,niveau,XSD_EXTENSION));
    }

    abstract protected String filePath(Filiere filiere,Niveau niveau,String extension);
}
