package com.GestionDeScolarite.interlay.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class DomElement
{
    private Document document;
    private DomUtils domUtils;

    public DomElement(Document document)
    {
        this.document = document;
        this.domUtils = new DomUtils(document);
    }
    public Document getDocument()
    {
        return document;
    }
    public DomUtils getDomUtils()
    {
        return domUtils;
    }

    public Element creatElement(String name) throws IOException
    {
        return this.creatElement(name,null);
    }
    public Element creatElement(String name, String value) throws IOException
    {
        return this.creatElement(name,value,null);
    }
    public Element creatElement(String name, String value, String... attributes) throws IOException
    {
        Element element = this.document.createElement(name);
        if ( value != null )
        {
            Text data = domUtils.getXMLData(value);
            element.appendChild(data);
        }
        if ( attributes != null )
        {
            int size = attributes.length ;
            Attr attr ;
            if ( size % 2 == 1 )
                throw new IOException("l'attribut doit avoir une valeur");
            for ( int i = 0 ; i < size-1 ; i += 2 )
            {
                element.setAttribute(attributes[i],attributes[i+1]);
            }
        }
        return element ;
    }
    public void fill(Element element, Element... subElements)
    {
        if ( subElements != null )
        {
            for ( Element subElement: subElements)
            {
                element.appendChild(subElement);
            }
        }
    }
    public void fill(Element element, List<Element> subElements)
    {
        if ( subElements != null )
        {
            for ( Element subElement: subElements)
            {
                element.appendChild(subElement);
            }
        }
    }
}
