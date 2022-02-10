package com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.DaoException;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.NoteXMLValidator;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.StudentXmlValidator;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.XmlValidator;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryException;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryProcessor;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltException;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import java.io.File;

public class CarteEtudiantGenerator extends PdfGenerator{

    private String cin;
    private String photo;

    public CarteEtudiantGenerator(Filiere filiere, Niveau niveau, String cin, String photo) {
        super(filiere, niveau);
        this.cin = cin;
        this.photo = photo;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    public void generatePDF() throws ServiceException {
        try {
            XmlValidator studentValidator = new StudentXmlValidator();
            studentValidator.validate(filiere,niveau);
            generateStudentXML(cin,photo);
            File xmlfile = new File(Paths.ABSOLUTE_PATH+Paths.STUDENTS_XML_PATH+"/Student.xml");
            File xsltfile = new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XSLT_FILES_DIRECTORY+"/carte_etudiant.xslt");
            processor.generatePDF(xmlfile,xsltfile,"carte_etudiant_"+cin);
        } catch (XsltException e) {
            throw new ServiceException("Probléme lors de la génération du PDF");
        } catch (DaoException e){
            throw new ServiceException("Fichier student ou bien note est non valide");
        }
    }

    private void generateStudentXML(String CIN, String photo) throws ServiceException {
        try {
            XQueryProcessor processor = new XQueryProcessor(filiere, niveau);
            processor.generateStudent(CIN,photo);
        }catch (XQueryException e)
        {
            throw new ServiceException("La fichier XML Student ne peut pas étre générer");
        }
    }
}
