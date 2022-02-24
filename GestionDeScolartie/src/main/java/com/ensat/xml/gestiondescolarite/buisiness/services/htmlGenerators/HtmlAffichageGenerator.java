package com.ensat.xml.gestiondescolarite.buisiness.services.htmlGenerators;

import com.ensat.xml.gestiondescolarite.buisiness.AffichageGenerator;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomElement;
import com.ensat.xml.gestiondescolarite.interlay.dom.DomUtils;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;

public abstract class HtmlAffichageGenerator<T> implements AffichageGenerator<T>
{
    protected Document document;
    protected Element root;
    protected String rootName;
    protected DomElement domElement;
    protected Filiere filiere;
    protected Niveau niveau;
    protected String module;

    public HtmlAffichageGenerator(Filiere filiere, Niveau niveau, String module) throws ServiceException
    {
        this.filiere = filiere;
        this.niveau = niveau;
        this.module = module;
        this.rootName = getRootName();
        try
        {
            this.document = DomUtils.getNewDocument();
            this.domElement = new DomElement(this.document);
        }
        catch (ParserConfigurationException pce)
        {
            throw new ServiceException("Error lors de la recuperation du document");
        }
    }
    @Override
    public void generateBeforeRatt(Filiere filiere, Niveau niveau, String module) throws ServiceException
    {
        new HtmlAffichageGeneratorStudentBeforeRatt(filiere,niveau,module).generateHtml();
        new HtmlAffichageGeneratorStudentListRatt(filiere,niveau,module).generateHtml();
    }
    public static void generateAvantRatt(Filiere filiere, Niveau niveau, String module) throws ServiceException
    {
        new HtmlAffichageGeneratorStudentBeforeRatt(filiere,niveau,module).generateHtml();
        new HtmlAffichageGeneratorStudentListRatt(filiere,niveau,module).generateHtml();
    }
    public static void generateApresRatt(Filiere filiere, Niveau niveau, String module) throws ServiceException
    {
        new HtmlAffichageGeneratorStudentAfterRatt(filiere,niveau,module).generateHtml();
    }
    @Override
    public void generateAfterRatt(Filiere filiere, Niveau niveau, String module) throws ServiceException
    {
        new HtmlAffichageGeneratorStudentAfterRatt(filiere,niveau,module).generateHtml();

    }
    abstract protected void generateHtml() throws ServiceException;
    abstract protected String getRootName();
}