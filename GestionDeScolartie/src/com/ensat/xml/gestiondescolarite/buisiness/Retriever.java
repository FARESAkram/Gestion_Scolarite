package com.GestionDeScolarite.buisiness;

import com.GestionDeScolarite.utils.enums.Filiere;
import com.GestionDeScolarite.utils.enums.Niveau;

import java.io.IOException;
import java.util.List;

public interface Retriever<T>
{
    /**
     * get date from System
     * @param filiere
     * @param niveau
     * @return
     * @throws IOException
     */
    List<T> getData(Filiere filiere, Niveau niveau) throws IOException;
}
