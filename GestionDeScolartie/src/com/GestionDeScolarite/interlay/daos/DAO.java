package com.GestionDeScolarite.interlay.daos;

import java.util.List;

public interface DAO<T>
{
    void findById(T obj) throws DaoException;
    List<T> all() throws DaoException;
}
