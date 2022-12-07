package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Etudiant;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);
    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Long idContrat);
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);

    public Integer nbContratsValides(Date startDate, Date endDate);
    public List<Contrat> getContratsValides(Date startDate, Date endDate);
    public int CountContrat(Etudiant etudiant);

    public boolean validate (Etudiant etudiant);
}
