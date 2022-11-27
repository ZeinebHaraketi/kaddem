package tn.esprit.springboot.kaddem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.kaddem1.entity.Departement;


public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
