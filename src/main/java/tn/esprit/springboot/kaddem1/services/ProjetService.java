package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Projet;
import tn.esprit.springboot.kaddem1.repository.ProjetRepository;

import java.util.List;

@Service
public class ProjetService implements  IProjetService{
    @Autowired
    ProjetRepository projetRepository;


    @Override
    public List<Projet> retrieveAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Projet updateProjet(Projet p) {
        return projetRepository.save(p);
    }

    @Override
    public Projet addProjet(Projet p) {
        return projetRepository.save(p);
    }

    @Override
    public Projet retrieveProjet(Integer idProjet) {
        return projetRepository.findById((long)idProjet).get();
    }

    @Override
    public void removeProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }
}
