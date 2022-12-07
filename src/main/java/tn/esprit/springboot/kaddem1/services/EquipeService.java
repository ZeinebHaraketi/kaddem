package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Equipe;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.entity.Niveau;
import tn.esprit.springboot.kaddem1.repository.EquipeRepository;

import java.util.List;

@Service
public class EquipeService implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;
    ContratService contratService;
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
    @Override
    public  void upgradeNiveau( Equipe equipe){
        Niveau niveau =  equipe.getNiveau();
        if(niveau == Niveau.JUNIOR){niveau = Niveau.SENIOR;}
        if(niveau == Niveau.SENIOR){niveau = Niveau.EXPERT;}
        equipe.setNiveau(niveau);
        equipeRepository.save(equipe);
    }
    @Override
    public void faireEvoluerEquipes(){
        List<Equipe> equipes = this.retrieveAllEquipes();
        for (Equipe equipe : equipes)
        {//System.out.println( equipe.getEtudiants().size());
            if ( equipe.getEtudiants().size() >= 3)
            {
                for (Etudiant etudiant : equipe.getEtudiants()) {
                    if ( contratService.validate(etudiant) ) {
                        this.upgradeNiveau(equipe);
                    }
                }
            }
        }
    }
}
