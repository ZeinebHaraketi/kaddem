package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Departement;

import java.util.List;

public interface IDepartementService {

    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Long idDepart);

    public void removeDepart(Long idDepart);

    public Departement assignEtudiantToDepartement(Integer etudiantId, Long departementId);

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    }
