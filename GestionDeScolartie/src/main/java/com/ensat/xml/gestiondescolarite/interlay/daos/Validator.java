package com.ensat.xml.gestiondescolarite.interlay.daos;

import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

public interface Validator
{
    void validate(Filiere filiere, Niveau niveau) throws DaoException;
}
