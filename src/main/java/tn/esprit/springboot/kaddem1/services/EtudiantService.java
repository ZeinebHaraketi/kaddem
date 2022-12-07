package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Equipe;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.repository.ContratRepository;
import tn.esprit.springboot.kaddem1.repository.EquipeRepository;
import tn.esprit.springboot.kaddem1.repository.EtudiantRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EtudiantService implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    EtudiantRepository er;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById((long)idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }


    public long ajoutEtudiant(Etudiant e){
        return etudiantRepository.save(e).getIdEtudiant();
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long idContrat, long idEquipe) {


        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        Set<Equipe> equipes=new HashSet<>();
        equipes.add(equipe);
        e.setEtudiantEquipe(equipes);
        er.save(e);
        Contrat contrat=contratRepository.findById(idContrat).orElse(null);
        contrat.setEtudiant(e);
        contratRepository.save(contrat);


        return e;
    }

   // @Override
    //public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
       // return er.findByDepartementsIdDepart(idDepartement);
    //}
}
