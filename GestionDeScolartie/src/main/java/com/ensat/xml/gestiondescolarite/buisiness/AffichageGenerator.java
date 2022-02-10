package com.ensat.xml.gestiondescolarite.buisiness;

import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

public interface AffichageGenerator<T>
{
    void generateBeforeRatt(Filiere filiere, Niveau niveau,String module) throws ServiceException;
    void generateAfterRatt(Filiere filiere, Niveau niveau,String module) throws ServiceException;
}
