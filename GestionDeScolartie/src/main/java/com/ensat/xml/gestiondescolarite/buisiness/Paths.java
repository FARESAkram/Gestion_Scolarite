package com.ensat.xml.gestiondescolarite.buisiness;

import java.nio.file.Path;

public abstract class Paths
{
    public static final Path CURRENT_PATH = java.nio.file.Paths.get("");
    public static final String ABSOLUTE_PATH = CURRENT_PATH.toAbsolutePath().toString();

    // EXECL FILES PATHS
    public static final String BD_PATH = "/../Base_de_donnée" ;
    public static final String MODULES_EXCELS_PATH = BD_PATH+"/Modules/ExcelFiles" ;
    public static final String STUDENTS_EXCELS_PATH = BD_PATH+"/Students/ExcelFiles" ;
    public static final String MATIERES_EXCELS_PATH = BD_PATH+"/Matieres/ExcelFiles" ;
    public static final String PROFS_EXCELS_PATH = BD_PATH+"/Profs/ExcelFiles" ;
    public static final String NOTES_EXCELS_PATH = BD_PATH+"/Notes/ExcelFiles";
    public static final String EXCEL_EXTENSION = ".xlsx";

    //XML FILES PATHS
    public static final String OUTPUT_DIRECTORY = "OUTPUT";
    public static final String OUTPUT_PATH = "/../"+OUTPUT_DIRECTORY ;
    public static final String STUDENTS_XML_PATH = OUTPUT_PATH+"/Students/XMLFiles" ;
    public static final String MATIERES_XML_PATH = OUTPUT_PATH+"/Matieres/XMLFiles" ;
    public static final String PROFS_XML_PATH = OUTPUT_PATH+"/Profs/XMLFiles" ;
    public static final String NOTES_XML_PATH = OUTPUT_PATH+"/Notes/XMLFiles";
    public static final String MODULES_XML_PATH = OUTPUT_PATH+"/Modules/XMLFiles";

    //XSD FILES PATHS
    public static final String XML_UTILS_DIRECTORY = "XMLUtils";
    public static final String XML_UTILS_PATH = "/../"+XML_UTILS_DIRECTORY ;
    public static final String XSD_FILES_DIRECTORY = "XSDs";
    public static final String STUDENTS_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY;
    public static final String MATIERES_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY ;
    public static final String PROFS_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY ;
    public static final String NOTES_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY;
    public static final String MODULES_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY;

    public static final String XML_EXTENSION = ".xml";
    public static final String XSD_EXTENSION = ".xsd";
    public static final String XSL_EXTENSION = ".xsl";
    public static final String XSLT_EXTENSION = ".xslt";
    public static final String XQUERY_EXTENSION = ".xquery";

}
