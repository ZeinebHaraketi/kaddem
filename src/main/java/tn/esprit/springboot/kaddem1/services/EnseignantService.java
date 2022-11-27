package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Enseignant;
import tn.esprit.springboot.kaddem1.repository.EnseignantRepository;

import java.util.List;

@Service
public class EnseignantService implements IEnseignantService{
    @Autowired
    EnseignantRepository enseignantRepository;


    @Override
    public List<Enseignant> retrieveAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant updateEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant addEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant retrieveEnseignant(Integer idEns) {
        return enseignantRepository.findById((long)idEns).get();
    }

    @Override
    public void removeEnseignant(Long idEns) {
        enseignantRepository.deleteById(idEns);
    }
}
