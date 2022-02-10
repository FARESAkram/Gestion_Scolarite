package com.ensat.xml.gestiondescolarite;

import com.ensat.xml.gestiondescolarite.utils.ASCIIart;

import java.util.Scanner;


public class Main
{
    public static Boolean DISABLE_WARNING = false;
    private static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args)
    {
        disableWarning(DISABLE_WARNING);
        ASCIIart.write("Gestion De Scolarite");    }
    public static void disableWarning(boolean disable)
    {
        if ( disable )
        {
            System.err.close();
            System.setErr(System.out);
        }
    }
}