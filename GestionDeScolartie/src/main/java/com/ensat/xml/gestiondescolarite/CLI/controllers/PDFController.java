package com.ensat.xml.gestiondescolarite.CLI.controllers;

import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.buisiness.services.pdfGenerator.*;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;

import java.io.IOException;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.*;

public class PDFController extends Controller{

     private String CNE;
     private int semaine;
     private String photo;

     public boolean getCNEFromUser(){
         System.out.print("Veuillez entrer le CNE de l'étudiant: ");
         this.CNE = scanner.nextLine();
         return true;
     }

    public boolean getSemaineFromUser(){
        String input;
        int choix=0;
        do{
            try{
                System.out.print("Veuillez entrer la semaine: ");
                input = scanner.nextLine();
                this.semaine = Integer.parseInt(input);
                if(semaine<1 || semaine>17){
                    throw new IOException("Semaine invalid");
                }
                return true;
            }catch (NumberFormatException e){
                alertFailure("veuillez entrer un entier");
            }catch (IOException e){
                alertFailure(e.getMessage());
                System.out.println("Voulez vous continuer? [Y/N]");
                String answer = scanner.nextLine();
                if("Y".equalsIgnoreCase(answer) || "yes".equalsIgnoreCase(answer)){
                    choix = 1;
                }
                else
                    choix = 0;
            }
        }while(choix!=0);
        return false;

    }

    public boolean getPhotoFromUser(){
        String input;
        System.out.print("Veuillez entrer le chemin du photo de profile: ");
        input = scanner.nextLine();
        this.photo = input;
        return true;
    }

    public void generateCarteEtudiant(){
        if(!getFiliereFromUser() || !getNiveauFromUser() || !getCNEFromUser() || !getPhotoFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try{
            PdfGenerator<Student> generator = new CarteEtudiantGenerator(getFiliere(),getNiveau(),CNE,photo);
            generator.generatePDF();
            alertSuccess("La carte d'étudiant est générée");
        }catch (ServiceException e){
            alertFailure(e.getMessage());
        }
    }

    public void generateAttestationReussite(){
        if(!getFiliereFromUser() || !getNiveauFromUser() || !getCNEFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try{
            PdfGenerator<Student> generator = new AttestationReussiteGenerator(getFiliere(),getNiveau(),CNE);
            generator.generatePDF();
            alertSuccess("L'attestation de reussite est générée");
        }catch (ServiceException e){
            alertFailure(e.getMessage());
        }
    }

    public void generateReleveNotesEtudiant(){
        if(!getFiliereFromUser() || !getNiveauFromUser() || !getCNEFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try{
            PdfGenerator<Student> generator = new ReleveNotesEtudiant(getFiliere(),getNiveau(),CNE);
            generator.generatePDF();
            alertSuccess("Le releve de note de l'etudiant est généré");
        }catch (ServiceException e){
            alertFailure(e.getMessage());
        }
    }

    public void generateReleveNotesClasse(){
        if(!getFiliereFromUser() || !getNiveauFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try{
            PdfGenerator<Student> generator = new ReleveNotesClasseGenerator(getFiliere(),getNiveau());
            generator.generatePDF();
            alertSuccess("Le releve de notes de classe est généré");
        }catch (ServiceException e){
            alertFailure(e.getMessage());
        }
    }

    public void generateEmploi(){
        if(!getFiliereFromUser() || !getNiveauFromUser() || !getSemaineFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try{
            PdfGenerator<Student> generator = new EmploiGenerator(getFiliere(),getNiveau(),semaine);
            generator.generatePDF();
            alertSuccess("L'emploi de temps est généré");
        }catch (ServiceException e){
            alertFailure(e.getMessage());
        }
    }
}
