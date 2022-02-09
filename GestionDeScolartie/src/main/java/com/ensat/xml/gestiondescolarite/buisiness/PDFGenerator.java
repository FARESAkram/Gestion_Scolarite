package com.ensat.xml.gestiondescolarite.buisiness;

import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;

import java.io.File;

public interface PDFGenerator<T>{
    void generateAttestationEtudiant(Filiere filiere, byte niveau, String CIN, String firstName, String lastName);
    void generateCarteEtudiant(Filiere filiere, byte niveau, String CIN, String firstName, String lastName);
    void generateReleveNotesClass(Filiere filiere, byte niveau);
    void generateReleveNotesEtudiant(Filiere filiere, byte niveau, String CIN, String firstName, String lastName);
}