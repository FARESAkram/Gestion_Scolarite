package com.ensat.xml.gestiondescolarite.interlay.dom;

import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DomUtils
{
    private static final Path CURRENT_PATH = Paths.get("");
    private static final String ABSOLUTE_PATH = CURRENT_PATH.toAbsolutePath().toString();
    private static final String XML_UTILS_PATH = "/../XMLUtils" ;
    private static final String XSD_PATH = XML_UTILS_PATH+"/XSDs" ;
    private static final String XSL_PATH = XML_UTILS_PATH+"/XSLs" ;
    private static final String XSLT_PATH = XML_UTILS_PATH+"/XSLTs" ;
    private static final String XQUERY_PATH = XML_UTILS_PATH+"/XQUERYs" ;
    private static final String XML_EXTENSION = ".xml";
    private static final String XSD_EXTENSION = ".xsd";

    private Document document;

    public DomUtils(Document document)
    {
        this.document = document;
    }
    public Text getXMLData(String data)
    {
        return document.createTextNode(data);
    }
    public static Document getNewDocument() throws ParserConfigurationException
    {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        return documentBuilder.newDocument();
    }
    public static void check(Filiere filiere , Niveau niveau) throws IOException
    {
        if ( filiere == Filiere.AP )
        {
            if ( niveau == Niveau.TROIS )
            {
                throw new IOException("le niveau choisit ne correspond pas à la filiere AP!");
            }
        }
        else
        {
            if ( niveau.getNumero() < Niveau.TOUS.getNumero() || niveau.getNumero() > Niveau.TROIS.getNumero() )
                throw new IOException("le niveau choisit ne correspond pas à la filiere "+filiere.getDef()+" !.");
        }
    }
    public static Document getDocumentFrom(String fileName) throws ParserConfigurationException, IOException, SAXException {
        FileInputStream file = new FileInputStream(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.parse(file);
    }
    public static void transformToXML(OutputStream ouput, Source source) throws TransformerException
    {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult streamResult = new StreamResult(ouput);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, streamResult);
    }
}
