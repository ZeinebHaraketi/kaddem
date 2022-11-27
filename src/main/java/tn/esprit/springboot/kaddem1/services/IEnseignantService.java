package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Enseignant;

import java.util.List;

public interface IEnseignantService {
    List<Enseignant> retrieveAllEnseignants();

    Enseignant updateEnseignant (Enseignant e);
    Enseignant addEnseignant (Enseignant e);

    Enseignant retrieveEnseignant (Integer idEns);
    void removeEnseignant(Long idEns);
}
