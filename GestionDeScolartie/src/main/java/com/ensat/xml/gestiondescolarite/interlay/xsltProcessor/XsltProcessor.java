package com.ensat.xml.gestiondescolarite.interlay.xsltProcessor;

import com.ensat.xml.gestiondescolarite.buisiness.Paths;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.NoteXMLValidator;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.StudentXmlValidator;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.XmlValidator;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XsltProcessor {

    public void generatePDF(File xmlfile, File xsltfile, String PDFName) throws XsltException{

        try {
            File pdfDir = new File("OUTPUT/PDFs");
            pdfDir.mkdirs();
            File pdfFile = new File(pdfDir, PDFName+".pdf");
            System.out.println(pdfFile.getAbsolutePath());
            // configure fopFactory as desired
            final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            // configure foUserAgent as desired
            // Setup output
            OutputStream out = new FileOutputStream(pdfFile);
            out = new java.io.BufferedOutputStream(out);
            try {
                // Construct fop with desired output format
                Fop fop;
                fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                // Setup XSLT
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));
                // Setup input for XSLT transformation
                Source src = new StreamSource(xmlfile);
                // Resulting SAX events (the generated FO) must be piped through to FOP
                Result res = new SAXResult(fop.getDefaultHandler());
                // Start XSLT transformation and FOP processing
                transformer.transform(src, res);
                System.out.println("Vous trouverez le fichier dans le chemin suivant: "+ Paths.ABSOLUTE_PATH+Paths.OUTPUT_PATH+"/PDFs");
            } catch (FOPException | TransformerException e) {
                throw new XsltException("Probléme rencontrer lors de la création du fichier PDF");
            } finally {
                out.close();
            }
        }catch(IOException exp){
            exp.printStackTrace();
        }

    }
}
