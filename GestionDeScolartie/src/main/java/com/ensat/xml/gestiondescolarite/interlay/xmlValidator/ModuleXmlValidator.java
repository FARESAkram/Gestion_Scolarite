package com.ensat.xml.gestiondescolarite.utils.xmlValidator;

import com.ensat.xml.gestiondescolarite.buisiness.models.Module;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

public class ModuleXmlValidator  extends XmlValidator<Module>{
    @Override
    protected String filePath(Filiere filiere, Niveau niveau, String extension) {
        return null;
    }
}
