package com.GestionDeScolarite.interlay.dom.Serializer;

import com.GestionDeScolarite.buisiness.Retriever;
import com.GestionDeScolarite.buisiness.Serializer;
import com.GestionDeScolarite.interlay.dom.DomElement;
import com.GestionDeScolarite.interlay.dom.DomUtils;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.GestionDeScolarite.utils.Paths.XML_EXTENSION;

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
            String ouputPath = getOutputPath()+"/"+ outputFileName +XML_EXTENSION;
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
