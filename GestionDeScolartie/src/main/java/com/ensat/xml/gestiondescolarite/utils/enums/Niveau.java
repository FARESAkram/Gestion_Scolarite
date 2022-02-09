package com.ensat.xml.gestiondescolarite.utils.enums;

public enum Niveau
{
    UN(1),
    DEUX(2),
    TROIS(3),
    TOUS(0);
    private int numero ;
    Niveau(int numero)
    {
        this.numero = numero;
    }
    public int getNumero()
    {
        return numero;
    }

    @Override
    public String toString() {
        return getNumero()+"";
    }
}
