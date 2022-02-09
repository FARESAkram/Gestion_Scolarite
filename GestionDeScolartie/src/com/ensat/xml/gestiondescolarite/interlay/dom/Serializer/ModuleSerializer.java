package com.GestionDeScolarite.interlay.dom.Serializer;

import com.GestionDeScolarite.buisiness.Retriever;
import com.GestionDeScolarite.buisiness.models.Matiere;
import com.GestionDeScolarite.buisiness.models.Module;
import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;
import org.w3c.dom.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.GestionDeScolarite.utils.Paths.ABSOLUTE_PATH;
import static com.GestionDeScolarite.utils.Paths.MODULES_XML_PATH;

public class ModuleSerializer extends XmlSerializer<Module>{

    private static final String MODULE_ROOT = "module";

    private static final String MATIERE_ELEMENT = "matiere";
    private static final String DEPARTEMENT_ELEMENT = "departement";

    private static final String CODE_ATTRIBUT = "code";
    private static final String NOM_ATTRIBUT = "nom";
    private static final String CLASS_ATTRIBUT = "class";

    public ModuleSerializer(Filiere filiere, Niveau niveau, Retriever<Module> retriever) throws IOException {
        super(filiere, niveau, retriever);
    }

    @Override
    protected void setRoot(List<Module> modules) throws IOException
    {
        String rootName = MODULE_ROOT+"s";
        List<Element> elements = new ArrayList<>();
        Element element = domElement.creatElement(rootName,null,CLASS_ATTRIBUT,super.filiere.toString()+super.niveau.toString());
        for(Module module:modules)
        {
            elements.add(getModuleRow(module));
        }
        domElement.fill(element,elements);
        super.root = element;
        document.appendChild(super.root);
        outputFileName = MODULE_ROOT+"s_"+filiere.toString()+niveau.toString();
    }
    private Element getModuleRow(Module module) throws IOException
    {
        Element root = domElement.creatElement(MODULE_ROOT, null, CODE_ATTRIBUT, module.getCode());
        Element matieres = getMatieres(module);
        Element department = domElement.creatElement(DEPARTEMENT_ELEMENT);
        domElement.fill(root,matieres,department);
        return root;
    }
    private Element getMatieres(Module module) throws IOException
    {
        Element root = domElement.creatElement(MATIERE_ELEMENT+"s",null,NOM_ATTRIBUT,module.getNom());
        List<Element> elements = new ArrayList<>();
        for(Matiere matiere: module.getMatieres())
        {
            elements.add(domElement.creatElement(MATIERE_ELEMENT,matiere.toString()));
        }
        domElement.fill(root,elements);
        return root;
    }
    @Override
    protected void generateXMLFile() throws IOException {
        if ( niveau == Niveau.TOUS)
        {
            setRootForAll();
        }
        else
        {
            setRoot(retriever.getData(filiere,niveau));
        }
    }

    @Override
    protected String getOutputPath() {
        return ABSOLUTE_PATH+MODULES_XML_PATH;
    }
    private void setRootForAll() throws IOException
    {
        ModuleSerializer tempo;
        Element e1,e2,e3,temp_root ;
        if ( filiere == Filiere.AP )
        {
            try
            {
                tempo = new ModuleSerializer(filiere,Niveau.UN,retriever);
                tempo.setRoot(retriever.getData(Filiere.AP,Niveau.UN));
                e1 = (Element) document.importNode(tempo.getRoot(),true);

                tempo = new ModuleSerializer(filiere,Niveau.DEUX,retriever);
                tempo.setRoot(retriever.getData(Filiere.AP,Niveau.DEUX));
                e2 = (Element) document.importNode(tempo.getRoot(),true);

                temp_root = document.createElement(root.toString());
                domElement.fill(temp_root,e1,e2);
                document.appendChild(temp_root);
                outputFileName = MODULE_ROOT+"s_"+filiere.toString();
            }
            catch (FileNotFoundException e)
            {
                throw new IOException(SERVER_ERROR_MESSAGE);
            }
        }
        else
        {
            try
            {
                tempo = new ModuleSerializer(filiere,Niveau.UN,retriever);
                tempo.generateXMLFile();
                e1 = (Element) document.importNode(tempo.getRoot(),true) ;

                tempo = new ModuleSerializer(filiere,Niveau.DEUX,retriever);
                tempo.generateXMLFile();
                e2 = (Element) document.importNode(tempo.getRoot(),true);

                tempo = new ModuleSerializer(filiere,Niveau.TROIS,retriever);
                tempo.generateXMLFile();
                e3 = (Element) document.importNode(tempo.getRoot(),true);

                Element rootFiliere = domElement.creatElement("all_"+MODULE_ROOT+"s",null,"Filiere",filiere.toString());

                domElement.fill(rootFiliere,e1,e2,e3);
                document.appendChild(rootFiliere);
                outputFileName = "all_"+MODULE_ROOT+"s_"+filiere.toString();
            }
            catch (DOMException e)
            {
                throw new IOException(SERVER_ERROR_MESSAGE);
            }

        }
    }
}
