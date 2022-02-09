package com.ensat.xml.gestiondescolarite.interlay;

import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

public interface Validator<T>
{
    void validate(Filiere filiere, Niveau niveau) throws DaoException;
}
