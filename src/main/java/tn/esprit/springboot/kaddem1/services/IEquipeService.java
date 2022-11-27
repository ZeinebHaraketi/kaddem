package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe (Integer idEquipe);


}
