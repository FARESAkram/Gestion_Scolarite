package com.ensat.xml.gestiondescolarite.CLI.controllers;

import com.ensat.xml.gestiondescolarite.utils.ASCIIart;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertFailure;
import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.write;

public abstract class Controller {
    private Filiere filiere;
    private Niveau niveau;
    protected static Scanner scanner = new Scanner(System.in);

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) throws IOException{
        switch (filiere.toUpperCase()){
            case "AP":
                this.filiere = Filiere.AP;
                break;
            case "GINF":
                this.filiere = Filiere.GINF;
                break;
            case "GSTR":
                this.filiere = Filiere.GSTR;
                break;
            case "G3EI":
                this.filiere = Filiere.G3EI;
                break;
            case "GSEA":
                this.filiere = Filiere.GSEA;
                break;
            case "GIL":
                this.filiere = Filiere.GIL;
                break;
            default:
                throw new IOException("Filiére invalid");
        }

    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) throws IOException{
        switch (niveau){
            case "1":
                this.niveau = Niveau.UN;
                break;
            case "2":
                this.niveau = Niveau.DEUX;
                break;
            case "3":
                this.niveau = Niveau.TROIS;
                break;
            case "0":
                this.niveau = Niveau.TOUS;
                break;
            default:
                throw new IOException("Niveau invalid");
        }
    }

    public boolean getFiliereFromUser(){
        System.out.println("Veuillez entrer le code de la filiére: ");
        int choix=0;
        do {
            try {
                System.out.println(Filiere.AP+" "+Filiere.GINF+" " +Filiere.GSTR    +" "+Filiere.GIL+" "+Filiere.GSEA+" "+Filiere.G3EI);
                setFiliere(scanner.nextLine());
                return true;
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
        }while (choix!=0);
        return false;
    }

    public boolean getNiveauFromUser(){
        System.out.println("Veuillez entrer le niveau: ");
        int choix=0;
        do {
            try {
                System.out.println(Niveau.UN+" "+Niveau.DEUX+" " +Niveau.TROIS+" (Pour cycle ingénieur) "+Niveau.TOUS+" (Tous les niveaux)");
                setNiveau(scanner.nextLine());
                return true;
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
        }while (choix!=0);
        return false;
    }
}
