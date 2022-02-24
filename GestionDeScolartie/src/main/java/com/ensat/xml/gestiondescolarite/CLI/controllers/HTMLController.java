package com.ensat.xml.gestiondescolarite.CLI.controllers;

import com.ensat.xml.gestiondescolarite.buisiness.models.Module;
import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.buisiness.services.htmlGenerators.HtmlAffichageGenerator;
import com.ensat.xml.gestiondescolarite.interlay.dom.Serializer.NoteSerializer;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;
import org.apache.xpath.operations.Mod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertFailure;
import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertSuccess;

public class HTMLController extends Controller{
    private Map<String, List<String>> modules;
    private String module;

    public HTMLController() {
        modules = new HashMap<>();
        modules.put("AP1",new ArrayList<>(List.of("AP11","AP12","AP13","AP14","AP15","AP16","AP21","AP22","AP23","AP24","AP25","AP26")));
        modules.put("AP2",new ArrayList<>(List.of("AP31","AP32","AP33","AP34","AP35","AP36","AP41","AP42","AP43","AP44","AP45","AP46")));
        modules.put("GINF1",new ArrayList<>(List.of("GINF11","GINF12","GINF13","GINF14","GINF15","GINF16","GINF21","GINF22","GINF23","GINF24","GINF25","GINF26")));
        modules.put("GINF2",new ArrayList<>(List.of("GINF31","GINF32","GINF33","GINF34","GINF35","GINF36","GINF41","GINF42","GINF43","GINF44","GINF45","GINF46")));
        modules.put("GINF3",new ArrayList<>(List.of("GINF51","GINF52","GINF53","GINF54","GINF55","GINF56")));
        modules.put("GSTR1",new ArrayList<>(List.of("GSTR11","GSTR12","GSTR13","GSTR14","GSTR15","GSTR16","GSTR21","GSTR22","GSTR23","GSTR24","GSTR25","GSTR26")));
        modules.put("GSTR2",new ArrayList<>(List.of("GSTR31","GSTR32","GSTR33","GSTR34","GSTR35","GSTR36","GSTR41","GSTR42","GSTR43","GSTR44","GSTR45","GSTR46")));
        modules.put("GSTR3",new ArrayList<>(List.of("GSTR51","GSTR52","GSTR53","GSTR54","GSTR55","GSTR56")));
        modules.put("G3EI1",new ArrayList<>(List.of("G3EI11","G3EI12","G3EI13","G3EI14","G3EI15","G3EI16","G3EI21","G3EI22","G3EI23","G3EI24","G3EI25","G3EI26")));
        modules.put("G3EI2",new ArrayList<>(List.of("G3EI31","G3EI32","G3EI33","G3EI34","G3EI35","G3EI36","G3EI41","G3EI42","G3EI43","G3EI44","G3EI45","G3EI46")));
        modules.put("G3EI3",new ArrayList<>(List.of("G3EI51","G3EI52","G3EI53","G3EI54","G3EI55","G3EI56")));
        modules.put("GIL1",new ArrayList<>(List.of("GIL11","GIL12","GIL13","GIL14","GIL15","GIL16","GIL21","GIL22","GIL23","GIL24","GIL25","GIL26")));
        modules.put("GIL2",new ArrayList<>(List.of("GIL31","GIL32","GIL33","GIL34","GIL35","GIL36","GIL41","GIL42","GIL43","GIL44","GIL45","GIL46")));
        modules.put("GIL3",new ArrayList<>(List.of("GIL51","GIL52","GIL53","GIL54","GIL55","GIL56")));
        modules.put("GSEA1",new ArrayList<>(List.of("GSEA11","GSEA12","GSEA13","GSEA14","GSEA15","GSEA16","GSEA21","GSEA22","GSEA23","GSEA24","GSEA25","GSEA26")));
        modules.put("GSEA2",new ArrayList<>(List.of("GSEA31","GSEA32","GSEA33","GSEA34","GSEA35","GSEA36","GSEA41","GSEA42","GSEA43","GSEA44","GSEA45","GSEA46")));
        modules.put("GSEA3",new ArrayList<>(List.of("GSEA51","GSEA52","GSEA53","GSEA54","GSEA55","GSEA56")));
    }

    public boolean getModuleFromUser(){
        System.out.print("Veuillez entrer le code de module: ");
        int choix=0;
        String input;
        do {
            try {
                System.out.println("La liste des modules est:"+modules.get(getFiliere().getDef().toUpperCase()+getNiveau().getNumero()));
                input = scanner.nextLine();
                input = input.toUpperCase();
                if(!modules.get(getFiliere().getDef().toUpperCase()+getNiveau().getNumero()).contains(input)){
                    throw new IOException("choix Invalid");
                }
                this.module = input;
                return true;
            }catch (IOException e){
                alertFailure(e.getMessage());
                System.out.print("Voulez vous continuer? [Y/N]");
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

    public void affichageAvantRatt(){
        if(!getFiliereFromUser() || !getNiveauFromUser() || !getModuleFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try {
            System.out.println("Génération de l'affichage de "+getFiliere()+getNiveau()+" pour le module"+module+" ...");
            HtmlAffichageGenerator.generateAvantRatt(getFiliere(),getNiveau(),module);
            alertSuccess("Le document est généré");
        } catch (ServiceException e) {
            alertFailure(e.getMessage());
        }
    }

    public void affichageApresRatt(){
        if(!getFiliereFromUser() || !getNiveauFromUser() || !getModuleFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }
        try {
            System.out.println("Génération de l'affichage finale de "+getFiliere()+getNiveau()+" pour le module"+module+" ...");
            HtmlAffichageGenerator.generateApresRatt(getFiliere(),getNiveau(),module);
            alertSuccess("Le document est généré");
        } catch (ServiceException e) {
            alertFailure(e.getMessage());
        }
    }
}
