package com.ensat.xml.gestiondescolarite.buisiness.models;

import java.util.ArrayList;
import java.util.List;

public class Professor
{
    private String cin;
    private String firstName;
    private String lastName;
    private String departement;
    private String phone;
    private String email;
    private List<Matiere> matieres;

    public Professor()
    {
        this.matieres = new ArrayList<>();
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    @Override
    public String toString() {
        return  lastName.toUpperCase()+" "+
                firstName.substring(0,1).toUpperCase()+
                firstName.substring(1).toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return professor.getCin().equalsIgnoreCase(this.getCin());
    }

    @Override
    public int hashCode() {
        int res = 0 ;
        if ( cin != null )
            res += cin.hashCode();
        if ( firstName != null )
            res += firstName.hashCode();
        if ( lastName != null )
            res += lastName.hashCode();
        if ( departement != null )
            res += departement.hashCode();
        if ( phone != null )
            res += phone.hashCode();
        if ( email != null )
            res += email.hashCode();
        return res;
    }
}