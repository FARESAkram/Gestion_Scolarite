package com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator;


import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import java.io.File;

public class ReleveNotesClasseGenerator<T> extends PdfGenerator<T>{

    public ReleveNotesClasseGenerator(Filiere filiere, Niveau niveau) {
        super(filiere, niveau);
    }

    @Override
    public void generatePDF() throws ServiceException {
        File xmlfile = new File(Paths.ABSOLUTE_PATH+Paths.NOTES_XML_PATH+"/Notes_"+filiere.getDef()+niveau+".xml");
        File xsltfile = new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XSLT_FILES_DIRECTORY+"/releve_de_notes_de_class.xslt");
        processor.generatePDF(xmlfile,xsltfile,"releve_de_notes_"+filiere.getDef()+niveau);
    }
}
