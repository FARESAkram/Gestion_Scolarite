package com.ensat.xml.gestiondescolarite.interlay.dom.Serializer;

import com.ensat.xml.gestiondescolarite.buisiness.Serializer;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomElement;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomUtils;
import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import com.ensat.xml.gestiondescolarite.buisiness.Retriever;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public abstract class XmlSerializer<T> implements Serializer<T>
{
    public static final String SERVER_ERROR_MESSAGE = "Server Error: Failed to generate file";

    protected Document document;
    protected DomElement domElement;
    protected Retriever<T> retriever;
    protected Filiere filiere;
    protected Niveau niveau;
    protected String outputFileName;
    protected Element root;

    public XmlSerializer(Filiere filiere,Niveau niveau, Retriever<T> retriever) throws IOException
    {
        this.filiere = filiere;
        this.niveau = niveau;
        this.retriever = retriever;
        try
        {
            this.document = DomUtils.getNewDocument();
            this.domElement = new DomElement(document);
        }
        catch (ParserConfigurationException e)
        {
            throw new IOException(SERVER_ERROR_MESSAGE);
        }
    }
    protected Element getRoot()
    {
        return root;
    }

    @Override
    public void serialize() throws IOException
    {
        File xmlDirectory = new File(getOutputPath());
        xmlDirectory.mkdirs();
        generateXML();
    }
    protected void generateXML() throws IOException
    {
        try
        {
            this.generateXMLFile();
            String ouputPath = getOutputPath()+"/"+ outputFileName + Paths.XML_EXTENSION;
            File outputFile = new File(ouputPath);
            DomUtils.transformToXML(new FileOutputStream(outputFile), new DOMSource(document));
        }
        catch (TransformerException e)
        {
            throw new IOException(SERVER_ERROR_MESSAGE);
        }
    }
    protected abstract void setRoot(List<T> data) throws IOException;
    protected abstract void generateXMLFile() throws IOException;
    protected abstract String getOutputPath();
}
