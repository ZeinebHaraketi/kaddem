package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Departement;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.entity.Universite;
import tn.esprit.springboot.kaddem1.repository.DepartementRepository;
import tn.esprit.springboot.kaddem1.repository.EtudiantRepository;
import tn.esprit.springboot.kaddem1.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DepartementService implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;
    EtudiantRepository etudiantRepository;

    UniversiteRepository universiteRepository;

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
    public void assignEtudiantToDepartement(long idDepart,long idEtud) {
        Etudiant etudiant = etudiantRepository.findById(idEtud).orElse(null);
        Departement departement = retrieveDepartement(idDepart);
        etudiant.setDepartements(departement);//aff
        etudiantRepository.save(etudiant);//sauvg
    }
    public Long ajoutDepartement(Departement d){
        return departementRepository.save(d).getIdDepart();
    }
    @Override
    public List<Departement> retrieveDepartementsByUniversite(long idUniversite) {
        Universite univ=universiteRepository.findById(idUniversite).orElse(null);
        Set<Departement> departements =new HashSet<>();
        departements=univ.getDepartements();
        List<Departement> ListDepartments = new ArrayList<>();
        ListDepartments.addAll(departements);
        //ListDepartments = departements.stream().collect(Collectors.toList());
        return  ListDepartments;
    }


}
