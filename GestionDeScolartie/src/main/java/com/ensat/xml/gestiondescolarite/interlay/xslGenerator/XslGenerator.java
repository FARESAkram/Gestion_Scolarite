package com.ensat.xml.gestiondescolarite.interlay.xslGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomElement;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomUtils;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.ensat.xml.gestiondescolarite.buisiness.Paths.*;

public abstract class XslGenerator<T>
{
    protected Document document;
    protected Element root;
    protected String rootName;
    protected DomElement domElement;
    protected Filiere filiere;
    protected Niveau niveau;
    protected String module;
    protected int validationNote;
    protected int EleminatoireNote;

    public XslGenerator(Filiere filiere, Niveau niveau, String module) throws XslException
    {
        this.filiere = filiere;
        this.niveau = niveau;
        this.module = module;
        if ( filiere == Filiere.AP )
        {
            validationNote = 10 ;
            EleminatoireNote = 7 ;
        }
        else
        {
            validationNote = 12 ;
            EleminatoireNote = 8 ;
        }
        this.rootName = getRootName();
        try
        {
            this.document = DomUtils.getNewDocument();
            this.domElement = new DomElement(this.document);
        }
        catch (ParserConfigurationException pce)
        {
            throw new XslException("Error lors de la recuperation du document");
        }
    }
    public void generateXSL() throws XslException
    {
        File xmlDirectory = new File(ABSOLUTE_PATH+STUDENTS_XSL_PATH);
        try
        {
            generateTemplate();
        }
        catch (IOException ioe)
        {
            throw new XslException("SERVER_ERROR: Failed to load HTML");
        }

        String ouputPath = ABSOLUTE_PATH+STUDENTS_XSL_PATH+"/"+getRootName()+XSL_EXTENSION;
        File outputFile = new File(ouputPath);
        try
        {
            DomUtils.transformToXML(new FileOutputStream(outputFile) , new DOMSource(this.document));
        }
        catch (TransformerException | FileNotFoundException e)
        {
            e.printStackTrace();
            throw new XslException("SERVER_ERROR: Failed to create file");
        }
    }
    abstract protected void generateTemplate() throws IOException;
    abstract protected String getRootName();
}
