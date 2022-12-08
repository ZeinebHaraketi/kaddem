package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Equipe;
import tn.esprit.springboot.kaddem1.repository.EquipeRepository;

import java.util.List;

@Service
public class EquipeService implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById((long)idEquipe).get();
    }

    public  long ajoutEquipe(Equipe e){
        return equipeRepository.save(e).getIdEquipe();
    }
}
