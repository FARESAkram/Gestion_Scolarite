package com.ensat.xml.gestiondescolarite.buisiness.services.TPGroupeGenerator;

import com.ensat.xml.gestiondescolarite.buisiness.GroupeGenerator;
import com.ensat.xml.gestiondescolarite.buisiness.services.ServiceException;
import com.ensat.xml.gestiondescolarite.interlay.DaoException;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.StudentXmlValidator;
import com.ensat.xml.gestiondescolarite.interlay.xmlValidator.XmlValidator;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryException;
import com.ensat.xml.gestiondescolarite.interlay.xqueryProcessor.XQueryProcessor;
import com.ensat.xml.gestiondescolarite.utils.enums.Filiere;
import com.ensat.xml.gestiondescolarite.utils.enums.Niveau;

public class TPGroupeGenerator<T> implements GroupeGenerator<T> {

    private Filiere filiere;
    private Niveau niveau;

    public TPGroupeGenerator(Filiere filiere, Niveau niveau) {
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    @Override
    public void generateGroupes() throws ServiceException {
        try{
            XmlValidator validator = new StudentXmlValidator();
            validator.validate(filiere,niveau);
            XQueryProcessor processor = new XQueryProcessor(filiere,niveau);
            processor.generateGroupTP();
        }catch (XQueryException e){
            throw new ServiceException("Le fichier des groupes ne peut pas étre generer");
        }catch (DaoException e){
            throw new ServiceException("Fichier student ou bien note est non valide");
        }
    }
}
