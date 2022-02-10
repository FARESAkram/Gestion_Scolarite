package com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomUtils;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import net.sf.saxon.s9api.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XQueryProcessor {

    private Filiere filiere;
    private Niveau niveau;

    public XQueryProcessor(Filiere filiere, Niveau niveau) {
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public void generateStudent(String CNE) throws XQueryException{
        File xmlFile = getFile("student","xml");
        File xqueryFile = getFile("student","xquery");
        generateFile(xmlFile,xqueryFile,getOutputPath("student"),"CNE",CNE,"filiere",filiere.getDef(),"niveau",niveau.getNumero()+"");
    }

    public void generateEmploiSemaine(int semaine) throws XQueryException{
        File xmlFile = getFile("semaine","xml");
        File xqueryFile = getFile("semaine","xquery");
        generateFile(xmlFile,xqueryFile,getOutputPath("semaine"),"numero",semaine+"","filiere",filiere.getDef(),"niveau",niveau.getNumero()+"");
    }

    public void generateGroupTP() throws XQueryException{
        File xmlFile = getFile("group","xml");
        File xqueryFile = getFile("group","xquery");
        for(int i=0;i<=getNumberOfGroupes();i++)
            generateFile(xmlFile,xqueryFile,getOutputPath("group")+(i+1)+".xml","groupSizeString",24+"","filiere",filiere.getDef(),"niveau",niveau.getNumero()+"","groupNumberString",(i+1)+"");

    }

    private void generateFile(File xmlFile,File xqueryFile,String outputPath,String... args) throws XQueryException
    {
        try
        {
            // the Saxon processor object
            Processor saxon = new Processor(false);
            // compile the query
            XQueryCompiler compiler = saxon.newXQueryCompiler();
            XQueryExecutable exec = compiler.compile(xqueryFile);

            // parse the string as a document node
            DocumentBuilder builder = saxon.newDocumentBuilder();

            InputStream inputStream = new FileInputStream(xmlFile);
            Source src = new StreamSource(inputStream);
            XdmNode doc = builder.build(src);
            // instantiate the query, bind the input and evaluate
            XQueryEvaluator query = exec.load();
            query.setContextItem(doc);
            if(args.length%2!=0)
                throw new XQueryException("Nombre d'argument incorrecte");

            for(int i=0;i<args.length-1;i+=2)
                query.setExternalVariable(new QName(args[i]),new XdmAtomicValue(args[i+1]));

            XdmValue result = query.evaluate();
            String ouputPath = outputPath;
            System.out.println(ouputPath);
            File outputFile = new File(ouputPath);
            try
            {
                XdmNode domSource = (XdmNode) result;
                DomUtils.transformToXML(new FileOutputStream(outputFile),domSource.asSource());
            }
            catch (TransformerException | FileNotFoundException e)
            {
                e.printStackTrace();
                throw new XQueryException("SERVER_ERROR: Failed to create file");
            }
        }
        catch (IOException | SaxonApiException e )
        {
            e.printStackTrace();
            throw new XQueryException("SERVER ERROR: Could not apply the XQUERY file on XML");
        }
    }

    private File getFile(String type,String extension){
        switch (type){
            case "student":
                if(extension.equals("xml"))
                    return new File(Paths.ABSOLUTE_PATH+"/"+Paths.STUDENTS_XML_PATH+"/Students_"+filiere.getDef()+niveau.getNumero()+".xml");
                else
                    return new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XQUERY_FILES_DIRECTORY+"/getStudent.xquery");

            case "semaine":
                if(extension.equals("xml"))
                    return new File(Paths.ABSOLUTE_PATH+"/"+Paths.EMPLOIS_EXCELS_PATH+"/Emploi_"+filiere.getDef()+niveau.getNumero()+".xml");
                else
                    return new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XQUERY_FILES_DIRECTORY+"/getEmploiWeek.xquery");

            case "group":
                if(extension.equals("xml"))
                    return new File(Paths.ABSOLUTE_PATH+"/"+Paths.STUDENTS_XML_PATH+"/Students_"+filiere.getDef()+niveau.getNumero()+".xml");
                else
                    return new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XQUERY_FILES_DIRECTORY+"/tpGroupsGenerator.xquery");

            default:
                return null;
        }
    }

    private String getOutputPath(String type) throws XQueryException{
        switch (type){
            case "student":
                return Paths.ABSOLUTE_PATH+Paths.STUDENTS_XML_PATH+"/Student.xml";
            case "semaine":
                return Paths.ABSOLUTE_PATH+Paths.EMPLOIS_XML_PATH+"/Emploi.xml";
            case "group":
                return Paths.ABSOLUTE_PATH+Paths.STUDENTS_XML_PATH+"/Group_"+filiere.getDef()+niveau.getNumero()+"_Groupe";
            default:
                throw new XQueryException("Invalid file type");
        }
    }

    private int getNumberOfGroupes() throws XQueryException
    {
        try
        {
            Document document = DomUtils.getDocumentFrom(Paths.ABSOLUTE_PATH+"/"+Paths.STUDENTS_XML_PATH+"/Students_"+filiere.getDef()+niveau+".xml");
            int numberOfStudents = document.getElementsByTagName("student").getLength();
            return 1+numberOfStudents/24;
        }
        catch (ParserConfigurationException | IOException | SAXException e)
        {
            throw new XQueryException("Failed to get Students File");
        }
    }

}