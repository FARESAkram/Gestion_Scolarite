package com.ensat.xml.gestiondescolarite.buisiness.services.htmlGenerators;

import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.DaoException;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.StudentXmlValidator;
import com.ensat.xml.gestiondescolarite.interlay.xslGenerator.XSLGeneratorAfterRatt;
import com.ensat.xml.gestiondescolarite.interlay.xslGenerator.XslException;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static com.ensat.xml.gestiondescolarite.buisiness.Paths.*;

public class HtmlAffichageGeneratorStudentAfterRatt extends HtmlAffichageGenerator<Student>
{
    public HtmlAffichageGeneratorStudentAfterRatt(Filiere filiere, Niveau niveau, String module) throws ServiceException {
        super(filiere, niveau, module);
    }

    @Override
    protected void generateHtml() throws ServiceException {
        try
        {
            new StudentXmlValidator().validate(super.filiere,super.niveau);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e.getMessage());
        }
        try
        {
            new XSLGeneratorAfterRatt(filiere,niveau,module).generateXSL();
        }
        catch (XslException e)
        {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
        TransformerFactory tFactory=TransformerFactory.newInstance();
        Source xslDoc=new StreamSource(ABSOLUTE_PATH+STUDENTS_XSL_PATH+"/"+getRootName()+XSL_EXTENSION);
        Source xmlDoc=new StreamSource(ABSOLUTE_PATH+NOTES_XML_PATH+"/"+"Notes_"+filiere.getDef()+niveau+XML_EXTENSION);
        String outputFileName=ABSOLUTE_PATH+NOTES_HTML_PATH+"/"+getRootName()+HTML_EXTENSION;
        try
        {
            File HtmlDir = new File(ABSOLUTE_PATH+NOTES_HTML_PATH);
            HtmlDir.mkdirs();
            OutputStream htmlFile=new FileOutputStream(outputFileName);
            Transformer transformer=tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch (FileNotFoundException | TransformerException e)
        {
            throw new ServiceException("Failed to generate HTML FILE");
        }
    }

    @Override
    protected String getRootName() {
        return "affichage_final_module_"+filiere.getDef()+niveau+"_"+module;
    }
}