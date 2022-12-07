package tn.esprit.springboot.kaddem1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.services.ContratService;

import java.util.Date;
import java.util.List;

@Tag(name = "Gestion Contrat")
@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratService contratService;

    @Operation(description = "Affichage de la liste des Contrats")
    @GetMapping("/allcontrat")
    private List<Contrat> allContrats(){
        return contratService.retrieveAllContrats();
    }

    @Operation(description = "Ajout d'un Contrat")
    @PostMapping("/addC")
    @ResponseBody
    public void ajoutContrat(@RequestBody Contrat c){
        contratService.ajoutContrat(c);
    }

    @Operation(description = "Suppression d'un Contrat")
    @DeleteMapping ("/sppC/{idContrat}")
    @ResponseBody
    public void supprimerContrat(@PathVariable("idContrat") Long idContrat){
        contratService.removeContrat(idContrat);
    }

    @Operation(description = "Modification d'un Contrat")
    @PutMapping("/modifC")
    private Contrat modifierContrat(@RequestBody Contrat c){
        return contratService.updateContrat(c);
    }

    @Operation(description = "Affichage d'un Contrat par Id")
    @GetMapping("/allcontrat/{idContrat}")
    private Contrat displayById(@PathVariable("idContrat") int idContrat){
        return contratService.retrieveContrat(idContrat);
    }

    @PutMapping("/affect/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant( @RequestBody Contrat ce,@PathVariable("nomE") String nomE, @PathVariable("prenomE") String prenomE){

        return contratService.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/chiffreAffaire/{startDate}/{endDate}")
    @ResponseBody
    public Float getChiffresAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        return contratService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }
}
