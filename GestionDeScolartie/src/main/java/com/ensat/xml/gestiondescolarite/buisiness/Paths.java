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

    public static final String OUTPUT_DIRECTORY = "OUTPUT";
    public static final String OUTPUT_PATH = "/../"+OUTPUT_DIRECTORY ;

    //XML FILES PATHS
    public static final String STUDENTS_XML_PATH = OUTPUT_PATH+"/Students/XMLFiles" ;
    public static final String MATIERES_XML_PATH = OUTPUT_PATH+"/Matieres/XMLFiles" ;
    public static final String PROFS_XML_PATH = OUTPUT_PATH+"/Profs/XMLFiles" ;
    public static final String NOTES_XML_PATH = OUTPUT_PATH+"/Notes/XMLFiles";
    public static final String MODULES_XML_PATH = OUTPUT_PATH+"/Modules/XMLFiles";

    //HTML FILES PATHS
    public static final String STUDENTS_HTML_PATH = OUTPUT_PATH+"/Students/HTMLFiles" ;
    public static final String MATIERES_HTML_PATH = OUTPUT_PATH+"/Matieres/HTMLFiles" ;
    public static final String PROFS_HTML_PATH = OUTPUT_PATH+"/Profs/HTMLFiles" ;
    public static final String NOTES_HTML_PATH = OUTPUT_PATH+"/Notes/HTMLFiles";
    public static final String MODULES_HTML_PATH = OUTPUT_PATH+"/Modules/HTMLFiles";


    public static final String XML_UTILS_DIRECTORY = "XMLUtils";
    public static final String XML_UTILS_PATH = "/../"+XML_UTILS_DIRECTORY ;

    //XSD FILES PATHS
    public static final String XSD_FILES_DIRECTORY = "XSDs";
    public static final String STUDENTS_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY;
    public static final String MATIERES_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY ;
    public static final String PROFS_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY ;
    public static final String NOTES_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY;
    public static final String MODULES_XSD_PATH = XML_UTILS_PATH+"/"+XSD_FILES_DIRECTORY;

    //XSL FILES PATHS;
    public static final String XSL_FILES_DIRECTORY = "XSLs";
    public static final String STUDENTS_XSL_PATH = XML_UTILS_PATH+"/"+XSL_FILES_DIRECTORY;
    public static final String MATIERES_XSL_PATH = XML_UTILS_PATH+"/"+XSL_FILES_DIRECTORY ;
    public static final String PROFS_XSL_PATH = XML_UTILS_PATH+"/"+XSL_FILES_DIRECTORY ;
    public static final String NOTES_XSL_PATH = XML_UTILS_PATH+"/"+XSL_FILES_DIRECTORY;
    public static final String MODULES_XSL_PATH = XML_UTILS_PATH+"/"+XSL_FILES_DIRECTORY;

    public static final String EXCEL_EXTENSION = ".xlsx";

    public static final String XML_EXTENSION = ".xml";
    public static final String XSD_EXTENSION = ".xsd";
    public static final String XSL_EXTENSION = ".xsl";
    public static final String XSLT_EXTENSION = ".xslt";
    public static final String XQUERY_EXTENSION = ".xquery";

    public static final String HTML_EXTENSION = ".html";

    public static final String STYLE_CSS_PATH = ABSOLUTE_PATH+NOTES_XML_PATH+"/../../../style.css";
}
