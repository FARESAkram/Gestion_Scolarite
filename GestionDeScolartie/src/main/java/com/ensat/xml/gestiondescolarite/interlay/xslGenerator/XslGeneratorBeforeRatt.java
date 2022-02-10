package com.ensat.xml.gestiondescolarite.interlay.xslGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.w3c.dom.Element;

import java.io.IOException;

import static com.ensat.xml.gestiondescolarite.buisiness.Paths.HTML_EXTENSION;
import static com.ensat.xml.gestiondescolarite.buisiness.Paths.STYLE_CSS_PATH;
import static com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.NoteSerializer.*;

public class XslGeneratorBeforeRatt extends XslGenerator<Student>
{
    public XslGeneratorBeforeRatt(Filiere filiere, Niveau niveau, String module) throws XslException {
        super(filiere, niveau, module);
    }

    @Override
    protected void generateTemplate() throws IOException {
        Element xsl_stylesheet = domElement.creatElement("xsl:stylesheet",null,
                "xmlns:xsl","http://www.w3.org/1999/XSL/Transform",
                "version","1.0");
        Element xsl_template = domElement.creatElement("xsl:template",null,"match","/");
        Element html = domElement.creatElement("html",null,"xsl:version","1.0","xmlns:xsl","http://www.w3.org/1999/XSL/Transform");
        Element linkTag = domElement.creatElement("link",null,"type","text/css","href",STYLE_CSS_PATH,"rel","stylesheet");
        Element body = domElement.creatElement("body");
        Element title = domElement.creatElement("h1","Affichage du module "+super.module+" avant rattrappage");
        Element table = domElement.creatElement("table",null,"border","1");
        Element tr_header = domElement.creatElement("tr");
        Element th_nom = domElement.creatElement("th",LAST_NAME_ELEMENT);
        Element th_prenom = domElement.creatElement("th",FIRST_NAME_ELEMENT);
        Element th_note = domElement.creatElement("th",MOYENNE_ELEMENT);
        Element studentRow = domElement.creatElement("xsl:for-each",null,"select","//"+MODULE_ROOT+"[@"+CODE_ATTRIBUT+"='"+module+"']//"+STUDENT_ROOT);
        Element tr_student = domElement.creatElement("tr");
        Element td_studentlastName = domElement.creatElement("td");
        Element validation = domElement.creatElement("xsl:if",null,"test",MOYENNE_ELEMENT+" >= "+validationNote);
        Element td_studentnote_valide = domElement.creatElement("td",null,"class","valide");
        Element rattSansElim = domElement.creatElement("xsl:if",null,"test",MOYENNE_ELEMENT+" < "+validationNote+" and "+MOYENNE_ELEMENT+" >= "+EleminatoireNote);
        Element td_studentnote_ratt_ss_elem = domElement.creatElement("td",null,"class","ratt");
        Element rattavecElim = domElement.creatElement("xsl:if",null,"test",MOYENNE_ELEMENT+" < "+EleminatoireNote);
        Element td_studentnote_ratt_vc_elem = domElement.creatElement("td",null,"class","rattElemin");
        Element value_lastName = domElement.creatElement("xsl:value-of",null,"select",LAST_NAME_ELEMENT);
        Element td_studentfirstName = domElement.creatElement("td");
        Element value_firstName = domElement.creatElement("xsl:value-of",null,"select",FIRST_NAME_ELEMENT);
        Element value_note1 = domElement.creatElement("xsl:value-of",null,"select",MOYENNE_ELEMENT);
        Element value_note2 = domElement.creatElement("xsl:value-of",null,"select",MOYENNE_ELEMENT);
        Element value_note3 = domElement.creatElement("xsl:value-of",null,"select",MOYENNE_ELEMENT);
        Element linkToList = domElement.creatElement("a","afficher la liste des ratrappages","href","./List_Rattrappage_"+filiere.getDef()+niveau+"_"+module+HTML_EXTENSION);
        domElement.fill(td_studentnote_valide,value_note1);
        domElement.fill(td_studentnote_ratt_ss_elem,value_note2);
        domElement.fill(td_studentnote_ratt_vc_elem,value_note3);
        domElement.fill(validation,td_studentnote_valide);
        domElement.fill(rattSansElim,td_studentnote_ratt_ss_elem);
        domElement.fill(rattavecElim,td_studentnote_ratt_vc_elem);
        domElement.fill(td_studentlastName,value_lastName);
        domElement.fill(td_studentfirstName,value_firstName);
        domElement.fill(tr_student,td_studentlastName,td_studentfirstName,validation,rattSansElim,rattavecElim);
        domElement.fill(studentRow,tr_student);
        domElement.fill(tr_header,th_nom,th_prenom,th_note);
        domElement.fill(table,tr_header,studentRow);
        domElement.fill(body,title,linkToList,table);
        domElement.fill(html,linkTag,body);
        domElement.fill(xsl_template,html);
        domElement.fill(xsl_stylesheet,xsl_template);
        this.root = xsl_stylesheet;
        document.appendChild(root);
    }

    @Override
    protected String getRootName() {
        return "affichage_module_"+filiere.getDef()+niveau+"_"+module;
    }
}
