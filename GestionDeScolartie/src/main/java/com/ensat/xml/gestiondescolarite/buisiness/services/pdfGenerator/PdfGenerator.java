package com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.PDFGenerator;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryException;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryProcessor;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

public abstract class PdfGenerator<T> implements PDFGenerator<T> {

    protected Filiere filiere;
    protected Niveau niveau;
    protected XsltProcessor processor;

    public PdfGenerator(Filiere filiere, Niveau niveau) {
        this.filiere = filiere;
        this.niveau = niveau;
        processor = new XsltProcessor();
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    protected void generateStudentXML(String CIN) throws ServiceException {
        try {
            XQueryProcessor processor = new XQueryProcessor(filiere, niveau);
            processor.generateStudent(CIN);
        }catch (XQueryException e)
        {
            throw new ServiceException("La fichier XML Student ne peut pas étre générer");
        }
    }
}
