package tn.esprit.springboot.kaddem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springboot.kaddem1.entity.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findByNomEContainsAndPrenomEContains(String nomE,String prenomE );

   // List<Etudiant> findByDepartementsIdDepart(Integer idDepart);
}
