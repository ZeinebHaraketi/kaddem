package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Long idEtudiant);
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long idContrat, long idEquipe);
    //public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement);
}
