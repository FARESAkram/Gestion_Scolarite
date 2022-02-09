package com.GestionDeScolarite.utils.enums;

public enum Type
{
    MODULE("Module"),
    STUDENT("Student"),
    MATIERE("Matiere"),
    PROF("Professor"),
    NOTE("Note");

    private String name;
    Type(String name)
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
