package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Departement;
import tn.esprit.springboot.kaddem1.entity.Universite;
import tn.esprit.springboot.kaddem1.repository.DepartementRepository;
import tn.esprit.springboot.kaddem1.repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService{

    @Autowired
    UniversiteRepository universiteRepository;
    private  UniversiteRepository ur;
    private  DepartementRepository departementsRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById((long)idUniversite).get();
    }

    public Long ajoutUniversite(Universite u){
        return universiteRepository.save(u).getIdUniv();
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, long idDepartement) {
        Universite univ=retrieveUniversite(idUniversite);
        Departement department=departementsRepository.findById(idDepartement).orElse(null);
        univ.getDepartements().add(department);
        ur.save(univ);
    }

}
