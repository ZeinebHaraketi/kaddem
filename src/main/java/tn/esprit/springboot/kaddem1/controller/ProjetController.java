package tn.esprit.springboot.kaddem1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Projet;
import tn.esprit.springboot.kaddem1.services.ProjetService;

import java.util.List;

@Tag(name = "Gestion Projet")
@RestController
@RequestMapping("/projet")
public class ProjetController {

    @Autowired
    ProjetService projetService;

    @Operation(description = "Affichage de la liste des projets")
    @GetMapping("/allprojet")
    private List<Projet> allProjets(){
        return projetService.retrieveAllProjets();
    }

    @Operation(description = "Ajout d'un projet")
    @PostMapping("/addP")
    @ResponseBody
    public Projet addProjet(@RequestBody Projet p) {
        return projetService.addProjet(p);
    }

    @Operation(description = "Modification d'un projet ")
    @PutMapping("/modifP")
    @ResponseBody
    public Projet updateProjet(@RequestBody  Projet p) {
        return projetService.updateProjet(p);
    }

    @Operation(description = "Suppression d'un projet")
    @DeleteMapping ("/sppP/{idProjet}")
    @ResponseBody
    public void removeProjet(@PathVariable("idProjet") Long idProjet) {
        projetService.removeProjet(idProjet);
    }


    @Operation(description = "Affichage d'un projet par Id")
    @GetMapping("/allprojet/{idProjet}")
    private Projet displayById(@PathVariable("idProjet") int idProjet){
        return projetService.retrieveProjet(idProjet);
    }
}
