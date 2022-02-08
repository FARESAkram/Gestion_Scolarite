package com.GestionDeScolarite.utils.xmlValidator;

import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;

public class ModuleXmlValidator  extends XmlValidator<Module>{
    @Override
    protected String filePath(Filiere filiere, Niveau niveau, String extension) {
        return null;
    }
}
