package com.ensat.xml.gestiondescolarite.buisiness;

import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;

public interface GroupeGenerator<T> {
    void generateGroupes() throws ServiceException;
}
