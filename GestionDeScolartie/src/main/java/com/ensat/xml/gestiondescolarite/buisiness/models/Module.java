package com.ensat.xml.gestiondescolarite.buisiness.models;

import java.util.ArrayList;
import java.util.List;

public class Module
{
    private String code;
    private String nom;
    private String departement;
    List<Matiere> matieres;

    public Module()
    {
        matieres = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    @Override
    public String toString() {
        return code+": "+nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return module.getCode().equalsIgnoreCase(this.getCode());
    }

    @Override
    public int hashCode() {
        int res = 0 ;
        if ( code != null )
            res += code.hashCode();
        return res;
    }
}