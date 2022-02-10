package com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;

public class AttestationReussiteGenerator<T> extends PdfGenerator<T>{

    private String cin;

    public AttestationReussiteGenerator(Filiere filiere, Niveau niveau, String cin) {
        super(filiere,niveau);
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    @Override
    public void generatePDF() throws ServiceException {
        generateStudentXML(cin);
        File xmlfile = new File(Paths.ABSOLUTE_PATH+Paths.STUDENTS_XML_PATH+"/Student.xml");
        File xsltfile = new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XSLT_FILES_DIRECTORY+"/attestation_de_reussite.xslt");
        processor.generatePDF(xmlfile,xsltfile,"Attestation_De_Reussite_"+cin);
    }
}
