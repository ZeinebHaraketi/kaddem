package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Equipe;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EtudiantService implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;

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

    /*
    @Transactional
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        Contrat contrat = contratRepository.findById(idContrat).get();
        Equipe equipe = equipeRespository.findById(idEquipe).get();
        e.getContrats().add(contrat);
        e.getEquipes().add(equipe);
        // contrat.setEtudiant(e);
        edtREpo.save(e);
        //etudiantRepository.save(contrat);
        System.out.println(e.getContrats());

        return e ;

    }*/

}
