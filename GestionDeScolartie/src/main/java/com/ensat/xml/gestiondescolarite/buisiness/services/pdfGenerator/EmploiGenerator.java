package com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.DaoException;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryException;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryProcessor;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltException;
import com.ensat.xml.gestiondescolarite.interlay.xsltProcessor.XsltProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import java.io.File;

public class EmploiGenerator<T> extends PdfGenerator<T>{

    private int semaine;

    public EmploiGenerator(Filiere filiere, Niveau niveau, int semaine) {
        super(filiere, niveau);
        this.semaine = semaine;
    }

    @Override
    public void generatePDF() throws ServiceException {
        generateEmploiSemaine();
        File xmlfile = new File(Paths.ABSOLUTE_PATH+Paths.EMPLOIS_XML_PATH+"/Emploi.xml");
        File xsltfile = new File(Paths.ABSOLUTE_PATH+Paths.XML_UTILS_PATH+"/"+Paths.XSLT_FILES_DIRECTORY+"/emploi.xslt");
        try {
            processor.generatePDF(xmlfile,xsltfile,"emploi_"+filiere.getDef()+niveau.getNumero()+"_semaine"+semaine);
        } catch (XsltException e) {
            throw new ServiceException("Probléme lors de la génération du PDF");
        }

    }

    private void generateEmploiSemaine() throws ServiceException{
        try {
            XQueryProcessor processor = new XQueryProcessor(filiere, niveau);
            processor.generateEmploiSemaine(semaine);
        }catch (XQueryException e)
        {
            throw new ServiceException("La fichier XML Emploi ne peut pas étre générer");
        }
    }
}
