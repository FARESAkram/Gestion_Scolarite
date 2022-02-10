package com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import java.io.File;

public class CarteEtudiantGenerator<T> extends PdfGenerator<T>{

    private String cin;

    public CarteEtudiantGenerator(Filiere filiere, Niveau niveau, String cin) {
        super(filiere,niveau);
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void generatePDF() throws ServiceException {
        generateStudentXML(cin);
        File xmlfile = new File(Paths.ABSOLUTE_PATH+Paths.STUDENTS_XML_PATH+"/Student.xml");
        File xsltfile = new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XSLT_FILES_DIRECTORY+"/carte_etudiant.xslt");
        processor.generatePDF(xmlfile,xsltfile,"carte_etudiant_"+cin);
    }
}