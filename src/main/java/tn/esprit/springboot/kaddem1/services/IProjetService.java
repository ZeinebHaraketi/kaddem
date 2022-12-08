package tn.esprit.springboot.kaddem1.services;


import tn.esprit.springboot.kaddem1.entity.Projet;

import java.util.List;

public interface IProjetService {

    List<Projet> retrieveAllProjets();

    Projet updateProjet (Projet p);
    Projet addProjet (Projet p);

    Projet retrieveProjet (Long idProjet);
    void removeProjet(Long idProjet);

    public Projet updateProjet(long id,Projet p);

}
