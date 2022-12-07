package tn.esprit.springboot.kaddem1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.entity.Specialite;
import tn.esprit.springboot.kaddem1.repository.ContratRepository;
import tn.esprit.springboot.kaddem1.repository.EtudiantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ContratService implements IContratService{
    Logger logger= LoggerFactory.getLogger(ContratService.class);
    @Autowired
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById((long)idContrat).get();
    }

    @Override
    public void removeContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    public Long ajoutContrat(Contrat c){
        return contratRepository.save(c).getIdContrat();
    }
    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant=etudiantRepository.findByNomEContainsAndPrenomEContains(nomE,prenomE);
        if(contratRepository.countContratsByEtudiants(etudiant)<5) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
            return ce;
        }
        else return null;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat=contratRepository.valideContratsBetween2dates(startDate,endDate);
        System.out.println(listContrat);
        float chiffre=0;
        for( Contrat c:listContrat){
            if(c.getArchive()==false){
                if(c.getSpecialite().equals(Specialite.IA)){
                    chiffre=chiffre+300;
                }
                else if (c.getSpecialite().equals(Specialite.RESEAUX)){
                    chiffre=chiffre+350;
                }
                else if(c.getSpecialite().equals(Specialite.CLOUD)){
                    chiffre=chiffre+400;
                }
                else if (c.getSpecialite().equals(Specialite.SECURITE)){
                    chiffre=chiffre+450;
                }
            }

        }
        return chiffre;
    }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  contratRepository.valideContratsBetween2dates(startDate,endDate);
    }


    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.ContratsValides(startDate, endDate);
    }

    @Override
    public List<Contrat> getContratsValides(Date startDate, Date endDate) {
        return contratRepository.findContratsByArchiveFalseAndDateDebutContratLikeAndAndDateFinContratLike(startDate,endDate);
    }

    @Scheduled(cron ="* * 15 * * *")
    public String retrieveStatusContrat(){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 15);
        String res=contratRepository.findByDateFinContratBetween(today,cal.getTime()).toString();
        logger.warn(res);
        return res;
    }
    @Override
    public int CountContrat(Etudiant etudiant)
    {
        List<Contrat>  contrats = this.retrieveAllContrats ();
        int count = 0;
        for (Contrat contrat  : contrats )
        {
            if ( contrat.getEtudiant() == null){continue;}
            if (contrat.getEtudiant().getIdEtudiant() == etudiant.getIdEtudiant()) {count++;}
        }
        return count;
    }
    @Override
    public boolean validate (Etudiant etudiant)
    {
        boolean verified = false;
        if (  this.CountContrat( etudiant) ==0 ){ return verified; }
        if ( etudiant.getContrats() == null ){ return verified; }
        Date dateNow =  new Date(System.currentTimeMillis());
        Set<Contrat> etudiantContrats = etudiant.getContrats();
        for (Contrat contrat  : etudiantContrats ) {
            if (  dateNow.compareTo(contrat.getDateFinContrat()) < 0     ) {
                verified = true;
                break;
            }
        }
        return verified;
    }
}
