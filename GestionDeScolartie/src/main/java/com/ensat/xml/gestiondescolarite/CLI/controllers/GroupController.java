package com.ensat.xml.gestiondescolarite.CLI.controllers;

import com.ensat.xml.gestiondescolarite.buisiness.models.Student;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.buisiness.services.TPGroupeGenerator.TPGroupeGenerator;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertFailure;
import static com.ensat.xml.gestiondescolarite.utils.ASCIIart.alertSuccess;

public class GroupController extends Controller{

    private TPGroupeGenerator<Student> generator;


    public void generateGroupTP(){
        if(!getFiliereFromUser() || !getNiveauFromUser()){
            System.out.println("Annulation d'opération");
            return;
        }

        this.generator = new TPGroupeGenerator(getFiliere(),getNiveau());
        try {
            generator.generateGroupes();
            alertSuccess("Les groupes de tp sont générés");
        } catch (ServiceException e) {
            alertFailure(e.getMessage());
        }
    }
}
