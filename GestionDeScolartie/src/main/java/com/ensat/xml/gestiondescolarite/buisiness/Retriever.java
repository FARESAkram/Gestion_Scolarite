package com.ensat.xml.gestiondescolarite.buisiness;

import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

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