package tn.esprit.springboot.kaddem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Etudiant;

import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat,Long> {


    @Query("select count (c) from Contrat  c where c.etudiant=:etudiant")
    Integer countContratsByEtudiants(Etudiant e);

    @Query("select  SUM(c.montantContrat) from Contrat c where c.dateFinContrat<=?2 and c.dateDebutContrat>=?1 and c.archive=false")
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2 and c.archive=false")
    List<Contrat> valideContratsBetween2dates(Date startDate, Date endDate);

    List<Contrat> findContratsByArchiveFalseAndDateDebutContratLikeAndAndDateFinContratLike(Date startDate, Date endDate);
    @Query("select count (c) from  Contrat c where (c.archive=false and  c.dateDebutContrat>=:startDate and  c.dateFinContrat<=:endDate)")
    Integer ContratsValides(@Param("startDate") Date startDate,@Param( "endDate") Date endDate);

    @Query("select c from Contrat c where c.dateFinContrat between ?1 and ?2")
    List<Contrat> findByDateFinContratBetween(Date dateFinContratStart, Date dateFinContratEnd);

}
