package com.ensat.xml.gestiondescolarite.interlay.daos;

import java.util.List;

public interface DAO<T>
{
    void findById(T obj) throws DaoException;
    List<T> all() throws DaoException;
}