package com.ensat.xml.gestiondescolarite.buisiness.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student
{
    private String cne ;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String classeName;
    private String phone;
    private String email;
    private Map<Module, Double> notes;

    public Student()
    {
        this.notes = new HashMap<>();
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClasseName() {
        return classeName;
    }

    public void setClasseName(String classeName) {
        this.classeName = classeName;
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

    public Map<Module, Double> getNotes() {
        return notes;
    }

    public void setNotes(Map<Module, Double> notes) {
        this.notes = notes;
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
        Student student = (Student) o;
        return student.getCne().equalsIgnoreCase(this.getCne());
    }

    @Override
    public int hashCode() {
        int res = 0 ;
        if ( cne != null )
            res += cne.hashCode();
        if ( firstName != null )
            res += firstName.hashCode();
        if ( lastName != null )
            res += lastName.hashCode();
        if ( dateOfBirth != null )
            res += dateOfBirth.hashCode();
        if ( classeName != null )
            res += classeName.hashCode();
        if ( phone != null )
            res += phone.hashCode();
        if ( email != null )
            res += email.hashCode();
        return res ;
    }
}
