package tn.esprit.springboot.kaddem1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.services.ContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratService contratService;

    @GetMapping("/allcontrat")
    private List<Contrat> allContrats(){
        return contratService.retrieveAllContrats();
    }

    @PostMapping("/addC")
    @ResponseBody
    public void ajoutContrat(@RequestBody Contrat c){
        contratService.ajoutContrat(c);
    }

    @DeleteMapping ("/sppC/{idContrat}")
    @ResponseBody
    public void supprimerContrat(@PathVariable("idContrat") Long idContrat){
        contratService.removeContrat(idContrat);
    }

    @PutMapping("/modifC")
    private Contrat modifierContrat(@RequestBody Contrat c){
        return contratService.updateContrat(c);
    }

    @GetMapping("/allcontrat/{idContrat}")
    private Contrat displayById(@PathVariable("idContrat") int idContrat){
        return contratService.retrieveContrat(idContrat);
    }
}
