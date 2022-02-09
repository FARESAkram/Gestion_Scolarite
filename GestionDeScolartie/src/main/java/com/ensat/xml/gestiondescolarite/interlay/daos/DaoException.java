package com.ensat.xml.gestiondescolarite.interlay.daos;

public class DaoException extends Exception
{
    public String SERVER_ERROR = "SERVER ERROR! COULD NOT PERFORM THIS ACTION";
    public DaoException(String message)
    {
        super(message);
    }
}
