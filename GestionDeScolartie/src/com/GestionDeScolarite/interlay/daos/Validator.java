package com.GestionDeScolarite.interlay.daos;

import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;

public interface Validator
{
    void validate(Filiere filiere, Niveau niveau) throws DaoException;
}
