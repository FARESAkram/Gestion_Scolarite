package com.ensat.xml.gestiondescolarite.utils.enums;

public enum Filiere
{
    AP("AP"),
    GINF("GINF"),
    GSTR("GSTR"),
    G3EI("G3EI"),
    GIL("GIL"),
    GSEA("GSEA");

    private String name ;
    Filiere(String name)
    {
        this.name = name;
    }
    public String getDef()
    {
        return name;
    }

    @Override
    public String toString() {
        return getDef();
    }
}
