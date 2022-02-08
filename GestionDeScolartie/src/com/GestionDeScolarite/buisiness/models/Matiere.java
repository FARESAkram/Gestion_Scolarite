package com.GestionDeScolarite.buisiness.models;

public class Matiere {
    private String nom;
    private Professor professor;

    public Matiere() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matiere matiere = (Matiere) o;
        return matiere.getNom().equalsIgnoreCase(this.getNom());
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}