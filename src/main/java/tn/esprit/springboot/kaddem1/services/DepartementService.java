package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Departement;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.repository.DepartementRepository;

import java.util.List;

@Service
public class DepartementService implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    EtudiantService etudiantService;


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
    public void assignEtudiantToDepartement(Integer etudiantId, Long departementId) {
        Etudiant e= etudiantService.retrieveEtudiant(etudiantId);
        e.setDepartements(retrieveDepartement((departementId)));
        etudiantService.updateEtudiant(e);
    }

    public Long ajoutDepartement(Departement d){
        return departementRepository.save(d).getIdDepart();
    }



}
