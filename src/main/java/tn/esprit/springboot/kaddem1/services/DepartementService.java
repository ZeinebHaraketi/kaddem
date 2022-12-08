package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Departement;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.entity.Universite;
import tn.esprit.springboot.kaddem1.repository.DepartementRepository;

import java.util.List;

@Service
public class DepartementService implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    UniversiteService universiteService;


    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Long idDepart) {
        return departementRepository.findById(idDepart).get();
    }

    @Override
    public void removeDepart(Long idDepart) {
        departementRepository.deleteById(idDepart);
    }

    @Override
    public Departement assignEtudiantToDepartement(Integer etudiantId, Long departementId) {

        Etudiant e=etudiantService.retrieveEtudiant(etudiantId);
        Departement d=retrieveDepartement(departementId);
        e.setDepartements(d);
        etudiantService.addEtudiant(e);
        return d;
    }

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Departement d=retrieveDepartement(Long.valueOf(idDepartement));
        Universite u=universiteService.retrieveUniversite(idUniversite);
        u.getDepartements().add(d);
        universiteService.addUniversite(u);
    }

    public Long ajoutDepartement(Departement d){
        return departementRepository.save(d).getIdDepart();
    }




}
