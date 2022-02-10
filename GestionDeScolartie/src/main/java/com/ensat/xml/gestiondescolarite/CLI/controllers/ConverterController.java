package com.ensat.xml.gestiondescolarite.CLI.controllers;

import com.ensat.xml.gestiondescolarite.buisiness.Retriever;
import com.ensat.xml.gestiondescolarite.buisiness.Serializer;
import com.ensat.xml.gestiondescolarite.buisiness.models.Professor;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.ModuleSerializer;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.NoteSerializer;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.ProfessorSerializer;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.StudentSerializer;
import com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever.ModuleRetriever;
import com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever.NotesRetriever;
import com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever.ProfessorsRetriever;
import com.ensat.xml.gestiondescolarite.interlay.excelDataRetriever.StudentsRetriever;
import com.ensat.xml.gestiondescolarite.utils.ASCIIart.*;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import com.ensat.xml.gestiondescolarite.buisiness.models.Module;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertFailure;
import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertSuccess;

public class ConverterController {
    Retriever<Module> moduleRetriever;
    Retriever<Student> studentRetriever;
    Retriever<Professor> professorRetriever;
    Retriever<Map.Entry<Module,List<Student>>> noteRetriever;

    public ConverterController() {
        this.moduleRetriever = new ModuleRetriever();
        this.studentRetriever = new StudentsRetriever();
        this.professorRetriever = new ProfessorsRetriever();
        this.noteRetriever = new NotesRetriever();
    }

    public void generateListModuleClasse(Filiere filiere, Niveau niveau){
        try {
            System.out.println("Génération de la liste des modules de "+filiere+niveau+" ...");
            Serializer<Module> moduleSerializer = new ModuleSerializer(filiere,niveau,moduleRetriever);
            moduleSerializer.serialize();
            alertSuccess("La liste est générée");
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }

    public void generateListEtudiantClasse(Filiere filiere, Niveau niveau){
        try {
            System.out.println("Génération de la liste des etudiants de "+filiere+niveau+" ...");
            Serializer<Student> studentSerializer = new StudentSerializer(filiere,niveau,studentRetriever);
            studentSerializer.serialize();
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }

    public void generateListProfessor(){
        try {
            System.out.println("Génération de la liste des professeurs ...");
            Serializer<Professor> professorSerializer = new ProfessorSerializer(professorRetriever);
            professorSerializer.serialize();
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }

    public void generateListNoteClasse(Filiere filiere, Niveau niveau){
        try {
            System.out.println("Génération de la liste des notes de                                                                                                         '"+filiere+niveau+" ...");
            Serializer<Map.Entry<Module,List<Student>>> noteSerializer = new NoteSerializer(filiere,niveau,noteRetriever);
            noteSerializer.serialize();
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }
}
