package tn.esprit.springboot.kaddem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springboot.kaddem1.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
