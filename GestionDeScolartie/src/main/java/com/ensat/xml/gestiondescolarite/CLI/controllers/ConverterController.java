package com.ensat.xml.gestiondescolarite.CLI.controllers;

import com.ensat.xml.gestiondescolarite.buisiness.Retriever;
import com.ensat.xml.gestiondescolarite.buisiness.Serializer;
import com.ensat.xml.gestiondescolarite.buisiness.models.Professor;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.*;
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
import java.util.Scanner;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertFailure;
import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertSuccess;

public class ConverterController extends Controller {
    private Scanner scanner;
    Retriever<Module> moduleRetriever;
    Retriever<Student> studentRetriever;
    Retriever<Professor> professorRetriever;
    Retriever<Map.Entry<Module,List<Student>>> noteRetriever;

    public ConverterController() {
        scanner = new Scanner(System.in);
        this.moduleRetriever = new ModuleRetriever();
        this.studentRetriever = new StudentsRetriever();
        this.professorRetriever = new ProfessorsRetriever();
        this.noteRetriever = new NotesRetriever();
    }

    public void generateListModuleClasse(){
        if(!getFiliereFromUser() || !getNiveauFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try {
            System.out.println("Génération de la liste des modules de "+getFiliere()+getNiveau()+" ...");
            Serializer<Module> moduleSerializer = new ModuleSerializer(getFiliere(),getNiveau(),moduleRetriever);
            moduleSerializer.serialize();
            alertSuccess("La liste est générée");
            alertSuccess("Vous Pouvez trouver le fichier dans le chemin suivant: ");
            System.out.println(moduleSerializer.getFullPath());
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }

    public void generateListEtudiantClasse(){
        if(!getFiliereFromUser() || !getNiveauFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try {
            System.out.println("Génération de la liste des etudiants de "+getFiliere()+getNiveau()+" ...");
            Serializer<Student> studentSerializer = new StudentSerializer(getFiliere(),getNiveau(),studentRetriever);
            studentSerializer.serialize();
            alertSuccess("La liste est générée");
            alertSuccess("Vous Pouvez trouver le fichier dans le chemin suivant: ");
            System.out.println(studentSerializer.getFullPath());
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }

    public void generateListProfessor(){
        try {
            System.out.println("Génération de la liste des professeurs ...");
            Serializer<Professor> professorSerializer = new ProfessorSerializer(professorRetriever);
            professorSerializer.serialize();
            alertSuccess("La liste est générée");
            alertSuccess("Vous Pouvez trouver le fichier dans le chemin suivant: ");
            System.out.println(professorSerializer.getFullPath());
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }

    public void generateListNoteClasse(){
        if(!getFiliereFromUser() || !getNiveauFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }

        try {
            System.out.println("Génération de la liste des notes de"+getFiliere()+getNiveau()+" ...");
            Serializer<Map.Entry<Module,List<Student>>> noteSerializer = new NoteSerializer(getFiliere(),getNiveau(),noteRetriever);
            noteSerializer.serialize();
            alertSuccess("La liste est générée");
            alertSuccess("Vous Pouvez trouver le fichier dans le chemin suivant: ");
            System.out.println(noteSerializer.getFullPath());
        } catch (IOException e) {
            alertFailure(e.getMessage());
        }
    }
}
