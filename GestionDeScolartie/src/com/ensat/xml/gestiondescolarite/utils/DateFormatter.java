package com.GestionDeScolarite.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter
{
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static String format(Date date)
    {
        return simpleDateFormat.format(date);
    }

    public static Date format(String string)
    {
        try
        {
            return simpleDateFormat.parse(string);
        }
        catch (ParseException pe)
        {
            return new Date();
        }
    }
}
