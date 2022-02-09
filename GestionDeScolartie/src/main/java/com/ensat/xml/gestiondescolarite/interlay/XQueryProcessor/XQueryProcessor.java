package com.ensat.xml.gestiondescolarite.interlay.XQueryProcessor;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomUtils;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import net.sf.saxon.s9api.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Path;

public class XQueryProcessor {

    private Filiere filiere;
    private Niveau niveau;

    public XQueryProcessor(Filiere filiere, Niveau niveau) {
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public void generateStudent(String CIN) throws XQueryException{
        File xmlFile = getFile("xml");
        File xqueryFile = getFile("xquery");
        generateFile(xmlFile,xqueryFile,"Student","CIN",CIN,"filiere",filiere.getDef(),"niveau",niveau.getNumero()+"");
    }

    private void generateFile(File xmlFile,File xqueryFile,String outputName,String... args) throws XQueryException
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
            for(int i=0;i<args.length-1;i+=2){
                query.setExternalVariable(new QName(args[i]),new XdmAtomicValue(args[i+1]));
            }
            XdmValue result = query.evaluate();
            System.out.println(result);
            String ouputPath = Paths.ABSOLUTE_PATH+"/GestionDeScolartie/OUTPUT/Students/XMLFiles/"+outputName+".xml";
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

    private File getFile(String extension){
        if(extension.equals("xml")){
            return new File("GestionDeScolartie/OUTPUT/Students/XMLFiles/Students_"+filiere.getDef()+niveau.getNumero()+".xml");
        }
        else{
            return new File("GestionDeScolartie/XMLUtils/XQUERYs/getStudent.xquery");
        }
    }
}