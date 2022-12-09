package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Projet;
import tn.esprit.springboot.kaddem1.repository.ProjetRepository;

import java.util.ArrayList;
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
    public Projet retrieveProjet(Long idProjet) {
        return projetRepository.findById(idProjet).get();
    }

    @Override
    public void removeProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }

    @Override
    public Projet updateProjet(long id, Projet p) {
        Projet toUpdateProjet =projetRepository.findById(id).get();
        if(projetRepository.findById(id).isPresent()){

            toUpdateProjet.setIdProjet(p.getIdProjet());
            toUpdateProjet.setDescription(p.getDescription());

            return projetRepository.save(toUpdateProjet);
        }
        return projetRepository.save(toUpdateProjet);
    }

    @Override
    public List<Projet> getProjetsPag(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Projet> pagedResult = projetRepository.findAll(paging);


        if (pagedResult.hasContent()){
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<Projet>();
        }
    }


}
