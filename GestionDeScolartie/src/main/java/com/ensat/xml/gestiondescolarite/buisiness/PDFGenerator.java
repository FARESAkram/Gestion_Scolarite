package com.ensat.xml.gestiondescolarite.buisiness;

import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;

import java.io.File;

public interface PDFGenerator<T>{
    void generatePDF() throws ServiceException;
}