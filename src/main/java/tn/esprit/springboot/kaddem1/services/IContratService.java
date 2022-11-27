package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);
    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Long idContrat);
}
