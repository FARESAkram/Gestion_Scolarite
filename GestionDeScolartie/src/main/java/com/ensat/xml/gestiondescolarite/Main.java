package com.ensat.xml.gestiondescolarite;

import com.ensat.xml.gestiondescolarite.CLI.controllers.ConverterController;
import com.ensat.xml.gestiondescolarite.CLI.controllers.GroupController;
import com.ensat.xml.gestiondescolarite.CLI.controllers.HTMLController;
import com.ensat.xml.gestiondescolarite.CLI.controllers.PDFController;
import com.ensat.xml.gestiondescolarite.buisiness.services.TPGroupeGenerator.TPGroupeGenerator;
import com.ensat.xml.gestiondescolarite.utils.ASCIIart;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertFailure;

public class Main
{
    public static Boolean DISABLE_WARNING = true;
    private static Scanner scanner;
    private static ConverterController converterController;
    private static HTMLController htmlController;
    private static PDFController pdfController;
    private static GroupController groupController;

    static{
        scanner = new Scanner(System.in);
        converterController = new ConverterController();
        htmlController = new HTMLController();
        pdfController = new PDFController();
        groupController = new GroupController();
    }

    private static void menu(){
        ArrayList<String> strings = new ArrayList<>(
                List.of(
                    "Générer la liste des étudiants d’une classe sous forme XML.",
                    "Générer la liste des modules d’une classe sous forme XML.",
                    "Générer la liste des notes d’une classe sous forme XML.",
                    "Générer la liste des professeurs de l’école.",
                    "Générer l’affichage d’un module sous forme HTML.",
                    "Générer la liste des étudiants ayant un rattrapage dans un module sous forme HTML.",
                    "Générer la carte d’étudiant sous forme PDF.",
                    "Générer l’emploi du temps d’une classe sous forme PDF.",
                    "Générer le relevé de note de la classe sous forme PDF.",
                    "Générer le relevé de note d’un étudiant sous forme PDF.",
                    "Générer l’attestation de réussite d’un étudiant sous forme PDF.",
                    "Générer les groupes de TP pour chaque classe sous forme XML.",
                    "Quitter"
                )
        );
        for(int i=0;i<strings.size();i++){
            System.out.println(i+1+". "+strings.get(i));
        }

    }

    private static int getChoix(){
        String choix;
        System.out.print("Veuillez entrer votre choix: ");
        while(true){
            try{
                choix = scanner.nextLine();
                return Integer.parseInt(choix);
            }catch (NumberFormatException e){
                alertFailure("Veuillez entrer un choix valid");
            }
        }
    }

    public static void main(String[] args)
    {
        int choix=-1;
        disableWarning(DISABLE_WARNING);
        ASCIIart.write("Gestion De Scolarite");
        System.out.println("Bienvenue dans l'application de gestion des notes");
        do{
            menu();
            choix = getChoix();
            switch (choix){
                case 1:
                    converterController.generateListEtudiantClasse();
                    break;
                case 2:
                    converterController.generateListModuleClasse();
                    break;
                case 3:
                    converterController.generateListNoteClasse();
                    break;
                case 4:
                    converterController.generateListProfessor();
                    break;
                case 5:
                    htmlController.affichageAvantRatt();
                    break;
                case 6:
                    htmlController.affichageApresRatt();
                    break;
                case 7:
                    pdfController.generateCarteEtudiant();
                    break;
                case 8:
                    pdfController.generateEmploi();
                    break;
                case 9:
                    pdfController.generateReleveNotesClasse();
                    break;
                case 10:
                    pdfController.generateReleveNotesEtudiant();
                    break;
                case 11:
                    pdfController.generateAttestationReussite();
                    break;
                case 12:
                    groupController.generateGroupTP();
                    break;
                case 13:
                    System.out.println("Au Revoir");
                    return;
                default:
                    alertFailure("Veuillez entrer un choix valide");

            }
        }while(choix != 13 );

    }
    public static void disableWarning(boolean disable)
    {
        if ( disable )
        {
            System.err.close();
            System.setErr(System.out);
        }
    }
}